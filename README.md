#ExpandLayout


ExpandLayout类来平滑过渡。
基本思路，动态的设置布局的高度。

## 核心动画效果代码

```java
   /**
     * 切换动画实现
     */
    private void animateToggle(long animationDuration) {
        ValueAnimator heightAnimation = isExpand ?
                ValueAnimator.ofFloat(retractHeight, viewHeight) : ValueAnimator.ofFloat(viewHeight,retractHeight);
        heightAnimation.setDuration(animationDuration / 2);
        heightAnimation.setStartDelay(animationDuration / 2);

        heightAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float val = (float) animation.getAnimatedValue();
                changeViewHeight(layoutView, (int) val);
            }
        });

        heightAnimation.start();
    }
```


```
	    checkbox= (CheckBox) findViewById(R.id.checkbox);
        checkbox.setOnClickListener(onClick);
        expand_layout = (ExpandLayout) findViewById(R.id.expand_layout);
        expand_layout.setRetractHeight(200f);//可通过这段设置缩放高度
        expand_layout.initExpand(true);//设定初始化折叠状态
		
		 View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.checkbox:
                    expand_layout.toggleExpand();
                    break;
            }
        }
    };
	
```

## 效果预览

![图片](https://github.com/aer874475222/ExpandLayout/blob/master/image/222.gif)


## 使用
因为ExpandLayout继承LinearLayout，所以可以在布局内直接包含控件

基于以下这位朋友的代码修改的
[带过渡动画的折叠收缩布局](https://github.com/ss518926/ExpandLayout).


