/*
 * From https://github.com/FabricMC/fabric/blob/1.16/fabric-api-base/src/main/java/net/fabricmc/fabric/impl/base/event/EventFactoryImpl.java
 * 
 */

/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.tr7zw.transliterationlib.api.event.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import dev.tr7zw.transliterationlib.api.event.api.TREvent;

public final class EventFactoryImpl {
	private static final List<ArrayBackedEvent<?>> ARRAY_BACKED_EVENTS = new ArrayList<>();

	private EventFactoryImpl() { }

	public static void invalidate() {
		ARRAY_BACKED_EVENTS.forEach(ArrayBackedEvent::update);
	}

	public static <T> TREvent<T> createArrayBacked(Class<? super T> type, Function<T[], T> invokerFactory) {
		return createArrayBacked(type, null /* buildEmptyInvoker(type, invokerFactory) */, invokerFactory);
	}

	public static <T> TREvent<T> createArrayBacked(Class<? super T> type, T emptyInvoker, Function<T[], T> invokerFactory) {
		ArrayBackedEvent<T> event = new ArrayBackedEvent<>(type, emptyInvoker, invokerFactory);
		ARRAY_BACKED_EVENTS.add(event);
		return event;
	}

}