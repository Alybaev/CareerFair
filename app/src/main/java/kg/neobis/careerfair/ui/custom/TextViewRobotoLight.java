package kg.neobis.careerfair.ui.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class TextViewRobotoLight extends android.support.v7.widget.AppCompatTextView {

    public TextViewRobotoLight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewRobotoLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewRobotoLight(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Light.ttf");
            setTypeface(tf);
        }
    }
}
