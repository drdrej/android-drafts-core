package com.touchableheroes.drafts.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Keep the work with intents as simple as possible.
 * Should be initialized inside the App-Instance.
 * 
 * @author A. Siebert / ask@touchabelheroes.com
 */
public class Intents {

	private Context ctx;

	public Intents(final Context ctx) {
		this.ctx = ctx;
	}
	
	public void newActivity(final String action, boolean shouldFinish) {
		final Intent intent = intent(action);
		ctx.startActivity(intent);

		if (shouldFinish && (ctx instanceof Activity))
			((Activity) ctx).finish();
	}

	public void newActivity(final Class<?> action, boolean shouldFinish) {
		final Intent intent = intent(action);
		ctx.startActivity(intent);

		if (shouldFinish && (ctx instanceof Activity))
			((Activity) ctx).finish();
	}
	
	private Intent intent(final String action) {
		final Intent intent = new Intent(action);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		return intent;
	}
	
	private Intent intent(final Class<?> action) {
		final Intent intent = new Intent(ctx, action);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		return intent;
	}	

	public void newActivity(final String action) {
		newActivity(action, false);
	}
	
	public void newActivity(final Class<?> action) {
		newActivity(action, false);
	}
	
	

}
