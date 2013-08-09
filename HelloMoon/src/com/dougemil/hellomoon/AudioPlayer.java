package com.dougemil.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

import com.dougemil.hellomoon.R;


public class AudioPlayer extends MediaPlayer{
	
	private MediaPlayer mPlayer;
	
	public void stop(){
		if (mPlayer != null){
			// Frees the resource instead of stopping and holding, best practice
			mPlayer.release();
			mPlayer=null;
		}
	}

	public void play(Context c){
		// Prevents creation of multiple MediaPlayer instances
		stop();
		
		// context is required to resolve R, different methods used for diff sources
		mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
		
		mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
			public void onCompletion(MediaPlayer mp){
				stop();
			}
		});
		mPlayer.start();
	}

	@Override
	public void pause() throws IllegalStateException {
		
		if(mPlayer.isPlaying())
			mPlayer.pause();
		else
			mPlayer.start();
		
	}
	
	
}
