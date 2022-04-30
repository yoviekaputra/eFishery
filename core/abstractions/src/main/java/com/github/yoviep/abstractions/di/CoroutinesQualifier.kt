package com.github.yoviep.abstractions.di

import javax.inject.Qualifier


/**
 * @created 30-04-2022 14:30
 * @author yoviekaputra
 * @project eFishery
 **/

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class MainDispatcher