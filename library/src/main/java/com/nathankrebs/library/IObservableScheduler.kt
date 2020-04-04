package com.nathankrebs.library

import com.nathankrebs.library.extensions.subscribeComputation
import com.nathankrebs.library.extensions.subscribeComputationObserveMain
import com.nathankrebs.library.extensions.subscribeIO
import com.nathankrebs.library.extensions.subscribeIoObserveComputation
import com.nathankrebs.library.extensions.subscribeIoObserveMain
import com.nathankrebs.library.extensions.subscribeTrampoline
import io.reactivex.CompletableTransformer
import io.reactivex.FlowableTransformer
import io.reactivex.MaybeTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer

abstract class IObservableScheduler {
    abstract fun <T> schedule(): ObservableTransformer<T, T>

    abstract fun <T> scheduleFlowable(): FlowableTransformer<T, T>

    abstract fun <T> scheduleMaybe(): MaybeTransformer<T, T>

    abstract fun <T> scheduleSingle(): SingleTransformer<T, T>

    abstract fun scheduleCompletable(): CompletableTransformer

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

            override fun scheduleCompletable(): CompletableTransformer =
                CompletableTransformer { it.subscribeIoObserveMain() }
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

            override fun scheduleCompletable(): CompletableTransformer =
                CompletableTransformer { it.subscribeComputationObserveMain() }
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

            override fun scheduleCompletable(): CompletableTransformer =
                CompletableTransformer { it.subscribeIoObserveComputation() }
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

            override fun scheduleCompletable(): CompletableTransformer =
                CompletableTransformer { it.subscribeTrampoline() }
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

            override fun scheduleCompletable(): CompletableTransformer =
                CompletableTransformer { it.subscribeComputation() }
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

            override fun scheduleCompletable(): CompletableTransformer =
                CompletableTransformer { it.subscribeIO() }
        }
    }
}