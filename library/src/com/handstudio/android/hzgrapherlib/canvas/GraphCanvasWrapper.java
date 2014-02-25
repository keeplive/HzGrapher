package com.handstudio.android.hzgrapherlib.canvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.handstudio.android.hzgrapherlib.util.MatrixTranslator;

/**
 * GraphCanvasWrapper class for drawing on reverse matrix (x coordinate) 
 * @author realwind
 */
public class GraphCanvasWrapper{
	
	private MatrixTranslator mMt;
	private Canvas mCanvas;
	
	public GraphCanvasWrapper(Canvas canvas, int width, int height, int paddingLeft, int paddingBottom) {
		mMt = new MatrixTranslator(width, height, paddingLeft, paddingBottom);
		mCanvas = canvas;
	}
	
	public Canvas getCanvas(){
		return mCanvas;
	}
	
	public void revDrawCircle(float cx, float cy, float radius, Paint paint) {
		mCanvas.drawCircle(mMt.calcX(cx), mMt.calcY(cy), radius, paint);
	}

	public void revDrawLine(float startX, float startY, float stopX, float stopY,
			Paint paint) {
		mCanvas.drawLine(mMt.calcX(startX), mMt.calcY(startY), 
				mMt.calcX(stopX), mMt.calcY(stopY), paint);
	}

	public void revDrawText(String text, float x, float y, Paint paint){
		mCanvas.drawText(text, mMt.calcX(x), mMt.calcY(y), paint);
	}
	
	public void revDrawBitmapIcon(Bitmap bitmap, float left, float top, Paint paint){
		mCanvas.drawBitmap(bitmap, mMt.calcBitmapCenterX(bitmap, left), mMt.calcBitmapCenterY(bitmap, top), paint);
	}
}
