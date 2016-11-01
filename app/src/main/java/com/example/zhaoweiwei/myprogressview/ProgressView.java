package com.example.zhaoweiwei.myprogressview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by zhaoweiwei on 2016/11/1.
 */

public class ProgressView extends ImageView {
	private AnimationDrawable animationDrawable;

	public ProgressView(Context context) {
		super(context);
		initView();
	}

	public ProgressView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public ProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView();
	}

	private void initView() {
		animationDrawable = (AnimationDrawable) getBackground();
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		startAnim();

	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		stopAnim();
	}
	@Override
	protected void onVisibilityChanged(View changedView, int visibility) {
		super.onVisibilityChanged(changedView, visibility);
		if (VISIBLE == visibility) {
			startAnim();
		} else {
			stopAnim();
		}
	}

	@Override
	public void setVisibility(int visibility) {
		if (getVisibility() != visibility) {
			super.setVisibility(visibility);
			if (visibility == GONE || visibility == INVISIBLE) {
				stopAnim();
			} else {
				startAnim();
			}
		}
	}

	private void startAnim() {
		if (animationDrawable == null) {
			initView();
		}
		if (animationDrawable != null) {
			animationDrawable.start();
		}
	}

	private void stopAnim() {
		if (animationDrawable == null) {
			initView();
		}
		if (animationDrawable != null) {
			animationDrawable.stop();
		}
	}
}
