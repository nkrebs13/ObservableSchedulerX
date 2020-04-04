package com.nathankrebs.library.extensions

import com.nathankrebs.library.IObservableScheduler
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.subscribeIO(): Observable<T> =
    this.subscribeOn(Schedulers.io()).observeOn(Schedulers.io())

fun <T> Observable<T>.subscribeIoObserveMain(): Observable<T> =
    this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.subscribeComputationObserveMain(): Observable<T> =
    this.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.subscribeTrampoline(): Observable<T> =
    this.subscribeOn(Schedulers.trampoline()).observeOn(Schedulers.trampoline())

fun <T> Observable<T>.subscribeComputation(): Observable<T> =
    this.subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation())

fun <T> Observable<T>.subscribeIoObserveComputation(): Observable<T> =
    this.subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())

fun <T> Observable<T>.composeScheduler(scheduler: IObservableScheduler): Observable<T> =
    this.compose(scheduler.schedule())