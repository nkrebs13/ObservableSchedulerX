package com.nathankrebs.library.extensions

import com.nathankrebs.library.IObservableScheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.subscribeIO(): Single<T> =
    this.subscribeOn(Schedulers.io()).observeOn(Schedulers.io())

fun <T> Single<T>.subscribeIoObserveMain(): Single<T> =
    this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.subscribeComputationObserveMain(): Single<T> =
    this.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.subscribeTrampoline(): Single<T> =
    this.subscribeOn(Schedulers.trampoline()).observeOn(Schedulers.trampoline())

fun <T> Single<T>.subscribeComputation(): Single<T> =
    this.subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation())

fun <T> Single<T>.subscribeIoObserveComputation(): Single<T> =
    this.subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())

fun <T> Single<T>.composeScheduler(scheduler: IObservableScheduler): Single<T> =
    this.compose(scheduler.scheduleSingle())