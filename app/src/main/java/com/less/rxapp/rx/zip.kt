package com.less.rxapp.rx

import android.util.Log
import com.less.rxapp.rx.Ex1.Companion.TAG
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.BiFunction

data class User(val userName: String)
data class UserPhoto(val user: User)
data class UserDetail(val user: User)
data class UserData(val userDetail: UserDetail, val userPhoto: UserPhoto)

class Zip {
    val getUsers: Observable<List<User>> =
        Observable.just(listOf(User("User1"), User("User2"), User("User3")))

    fun getUserDetail(user: User): Observable<UserDetail> = Observable.just(UserDetail(user))
    fun getUserPhoto(user: User): Observable<UserPhoto> = Observable.just(UserPhoto(user))

    fun getUserData(user: User): ObservableSource<UserData> =
        Observable.zip(getUserDetail(user), getUserPhoto(user),
            BiFunction<UserDetail, UserPhoto, UserData>()
            { userDetail: UserDetail, userPhoto: UserPhoto -> UserData(userDetail = userDetail, userPhoto = userPhoto)
            })

    fun saveUserData(userData:UserData) {
        Log.d(TAG, "saveUserData: "+userData.userDetail.user.userName)}

    fun resultFun() = getUsers.flatMap { userList ->
        Observable.fromIterable(userList)
    }
        .flatMap{ user -> getUserData(user) }
        .subscribe{userData -> saveUserData(userData)}
}

