package com.nathankrebs.library

import androidx.annotation.VisibleForTesting
import com.nathankrebs.library.extensions.*
import io.reactivex.FlowableTransformer
import io.reactivex.MaybeTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers


abstract class IObservableScheduler {
    abstract fun <T> schedule(): ObservableTransformer<T, T>

    abstract fun <T> scheduleFlowable(): FlowableTransformer<T, T>

    abstract fun <T> scheduleMaybe(): MaybeTransformer<T, T>

    abstract fun <T> scheduleSingle(): SingleTransformer<T, T>


    companion object {

        @JvmStatic
        fun subscribeIoObserveAndroidMain(): IObservableScheduler = object : IObservableScheduler() {
            override fun <T> schedule(): ObservableTransformer<T, T> =
                ObservableTransformer { it.subscribeIoObserveMain() }

            override fun <T> scheduleFlowable(): FlowableTransformer<T, T> =
                FlowableTransformer { it.subscribeIoObserveMain() }

            override fun <T> scheduleMaybe(): MaybeTransformer<T, T> =
                MaybeTransformer { it.subscribeIoObserveMain() }

            override fun <T> scheduleSingle(): SingleTransformer<T, T> =
                SingleTransformer { it.subscribeIoObserveMain() }
        }

        @JvmStatic
        fun subscribeComputationObserveAndroidMain(): IObservableScheduler = object : IObservableScheduler() {
            override fun <T> schedule(): ObservableTransformer<T, T> =
                ObservableTransformer { it.subscribeComputationObserveMain() }

            override fun <T> scheduleFlowable(): FlowableTransformer<T, T> =
                FlowableTransformer { it.subscribeComputationObserveMain() }

            override fun <T> scheduleMaybe(): MaybeTransformer<T, T> =
                MaybeTransformer { it.subscribeComputationObserveMain() }

            override fun <T> scheduleSingle(): SingleTransformer<T, T> =
                SingleTransformer { it.subscribeComputationObserveMain() }
        }

        @JvmStatic
        fun subscribeIoObserveComputation(): IObservableScheduler = object : IObservableScheduler() {
            override fun <T> schedule(): ObservableTransformer<T, T> =
                ObservableTransformer { it.subscribeIoObserveComputation() }

            override fun <T> scheduleFlowable(): FlowableTransformer<T, T> =
                FlowableTransformer { it.subscribeIoObserveComputation() }

            override fun <T> scheduleMaybe(): MaybeTransformer<T, T> =
                MaybeTransformer { it.subscribeIoObserveComputation() }

            override fun <T> scheduleSingle(): SingleTransformer<T, T> =
                SingleTransformer { it.subscribeIoObserveComputation() }
        }

        @JvmStatic
        fun trampoline(): IObservableScheduler = object : IObservableScheduler() {
            override fun <T> schedule(): ObservableTransformer<T, T> =
                ObservableTransformer { it.subscribeTrampoline() }

            override fun <T> scheduleFlowable(): FlowableTransformer<T, T> =
                FlowableTransformer { it.subscribeTrampoline() }

            override fun <T> scheduleMaybe(): MaybeTransformer<T, T> =
                MaybeTransformer { it.subscribeTrampoline() }

            override fun <T> scheduleSingle(): SingleTransformer<T, T> =
                SingleTransformer { it.subscribeTrampoline() }
        }

        @JvmStatic
        fun computation(): IObservableScheduler = object : IObservableScheduler() {
            override fun <T> schedule(): ObservableTransformer<T, T> =
                ObservableTransformer { it.subscribeComputation() }

            override fun <T> scheduleFlowable(): FlowableTransformer<T, T> =
                FlowableTransformer { it.subscribeComputation() }

            override fun <T> scheduleMaybe(): MaybeTransformer<T, T> =
                MaybeTransformer { it.subscribeComputation() }

            override fun <T> scheduleSingle(): SingleTransformer<T, T> =
                SingleTransformer { it.subscribeComputation() }
        }

        @JvmStatic
        fun io(): IObservableScheduler = object : IObservableScheduler() {
            override fun <T> schedule(): ObservableTransformer<T, T> =
                ObservableTransformer { it.subscribeIO() }

            override fun <T> scheduleFlowable(): FlowableTransformer<T, T> =
                FlowableTransformer { it.subscribeIO() }

            override fun <T> scheduleMaybe(): MaybeTransformer<T, T> =
                MaybeTransformer { it.subscribeIO() }

            override fun <T> scheduleSingle(): SingleTransformer<T, T> =
                SingleTransformer { it.subscribeIO() }
        }

        @JvmStatic
        @VisibleForTesting
        fun setUpRxJavaPluginsForUnitTests() {
            RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
            RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        }

        @JvmStatic
        @VisibleForTesting
        fun tearDownRxJavaPlugins() {
            RxJavaPlugins.reset()
            RxAndroidPlugins.reset()
        }
    }
}