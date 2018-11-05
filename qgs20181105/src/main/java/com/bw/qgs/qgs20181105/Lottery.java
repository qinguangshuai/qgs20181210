package com.bw.qgs.qgs20181105;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

/**
 * date:2018/11/5    8:52
 * author:秦广帅(Lenovo)
 * fileName:Lottery
 */
public class Lottery extends View implements View.OnClickListener {

    private int[] color = new int[]{Color.parseColor("#ff2522"),
            Color.parseColor("#766584"),
            Color.parseColor("#066f35"),
            Color.parseColor("#680070"),
            Color.parseColor("#ff2661"),
            Color.parseColor("#6025ff")};
    private  String[] colorText = new String[]{"参奖","谢谢参与","一等奖","二等奖","三等奖","四等奖"};
    private int mHeightPixels;
    private int mWidthPixels;
    private int mWidth;
    private int mHeight;
    private Paint mPaint;
    private boolean isRote;
    private Animation mAnimation;
    private int mColor1;
    private int mColor2;
    private int mColor3;
    private int mColor4;
    private int mColor5;
    private int mColor6;

    public Lottery(Context context) {
        this(context,null);
    }

    public Lottery(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public Lottery(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取屏幕宽高
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        mWidthPixels = displayMetrics.widthPixels;
        mHeightPixels = displayMetrics.heightPixels;
        //获取中心点
        mWidth = mWidthPixels / 2;
        mHeight = mHeightPixels / 2;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Lottery);
        mColor1 = typedArray.getColor(R.styleable.Lottery_mainColor1, 0);
        mColor2 = typedArray.getColor(R.styleable.Lottery_mainColor2, 0);
        mColor3 = typedArray.getColor(R.styleable.Lottery_mainColor3, 0);
        mColor4 = typedArray.getColor(R.styleable.Lottery_mainColor4, 0);
        mColor5 = typedArray.getColor(R.styleable.Lottery_mainColor5, 0);
        mColor6 = typedArray.getColor(R.styleable.Lottery_mainColor6, 0);
        //初始化画布
        initPaint();
        //动画
        initAnimation();
        //点击事件
        this.setOnClickListener(this);
    }

    private void initPaint() {
        mPaint = new Paint();
        //颜色
        mPaint.setColor(Color.RED);
        //填充
        mPaint.setStyle(Paint.Style.FILL);
        //聚合尺
        mPaint.setAntiAlias(true);
        //宽度
        mPaint.setStrokeWidth(2);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //移动
        canvas.translate(mWidth,mHeight);
        //获取矩形
        RectF rectF = new RectF(-260,-260,260,260);
        /*float start = 60;
        for (int i = 0;i<6;i++){
            mPaint.setColor(color[i]);
            canvas.drawArc(rectF,start*i,60,true,mPaint);
        }*/
        if(mColor1!=-1){
            mPaint.setColor(mColor1);
            canvas.drawArc(rectF,60*0,60,true,mPaint);

        }
        if(mColor1!=-1){
            mPaint.setColor(mColor2);
            canvas.drawArc(rectF,60*1,60,true,mPaint);

        }
        if(mColor2!=-1){
            mPaint.setColor(mColor3);
            canvas.drawArc(rectF,60*2,60,true,mPaint);

        }
        if(mColor3!=-1){
            mPaint.setColor(mColor4);
            canvas.drawArc(rectF,60*3,60,true,mPaint);

        }
        if(mColor4!=-1){
            mPaint.setColor(mColor5);
            canvas.drawArc(rectF,60*4,60,true,mPaint);

        }
        if(mColor5!=-1){
            mPaint.setColor(mColor6);
            canvas.drawArc(rectF,60*5,60,true,mPaint);

        }

        //绘制小圆
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(0,0,100,mPaint);
        //设置start位置
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(20);
        Rect rect = new Rect();
        mPaint.getTextBounds("start",0,5,rect);
        int width = rect.width();
        int height = rect.height();
        canvas.drawText("start",width/2-40,height/2,mPaint);
        //字体位置
        RectF mRectf = new RectF(-200,-200,200,200);
        for (int i = 0;i<6;i++){
            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(20);
            Path path = new Path();
            path.addArc(mRectf,60*i+20,60);
            canvas.drawTextOnPath(colorText[i],path,0,0,mPaint);
        }
    }
    public void initAnimation(){
        mAnimation = new RotateAnimation(0,360,mWidth,mHeight);
        //时间
        mAnimation.setDuration(3000);
        mAnimation.setFillAfter(true);
        //设置重复模式
        mAnimation.setRepeatMode(Animation.RESTART);
        //设置重复次数
        mAnimation.setRepeatCount(-1);
        //设置xml属性
        mAnimation.setInterpolator(new LinearInterpolator());
    }

    @Override
    public void onClick(View v) {

        if(isRote){
            stop();
            radom();
        }else {
            if(hua!=null){
                hua.dong(v);
            }
            start();
        }

    }
    public void start(){
        isRote = true;
        startAnimation(mAnimation);
    }
    public void stop(){
        isRote = false;
        clearAnimation();
    }
    public void radom(){
        double random = Math.random();
        RotateAnimation rotateAnimation = new RotateAnimation(0, (float) (360*random),mWidth,mHeight);
        rotateAnimation.setDuration(10);
        rotateAnimation.setFillAfter(true);
        startAnimation(rotateAnimation);
    }
    private donghua hua;
    public interface donghua{
        Void dong(View view);
    }
    public void HttpDong(donghua hua){
        this.hua = hua;
    }
}
