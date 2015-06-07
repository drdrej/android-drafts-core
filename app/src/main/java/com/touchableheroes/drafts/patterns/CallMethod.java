package com.touchableheroes.drafts.patterns;

import java.lang.reflect.Method;


/**
 * Reflection.Command to call java-methods.
 * 
 * @author A. Siebert / ask@touchableheroes.com
 *
 * @param <T>
 */
public class CallMethod<T> {

	private final Object source;
	private final Class<? extends Object> type;

	public CallMethod(final Object source) {
		this.source = source;
		this.type = this.source.getClass();
	}

	public T method(final String methodName, final Object... args) {
		try {
			final Method method = create(methodName, args);
			return (T) method.invoke(this.source, args);
		} catch (final Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	private Method create(final String methodName, final Object... args)
			throws NoSuchMethodException {
		final Class<?>[] argTypes = new Class<?>[args.length];

		for (int i = 0; i < args.length; i++) {
			final Object val = args[i];
			final Class<?> type = val.getClass();

			argTypes[i] = type;
		}

		switch (args.length) {
		case 0:
			return type.getMethod(methodName);
		case 1:
			return type.getMethod(methodName, argTypes[0]);
		case 2:
			return type.getMethod(methodName, argTypes[0], argTypes[1]);
		case 3:
			return type.getMethod(methodName, argTypes[0], argTypes[1], argTypes[2]);

		default:
			throw new NoSuchMethodException("couldn't call method "
					+ methodName);
		}

	}

}
