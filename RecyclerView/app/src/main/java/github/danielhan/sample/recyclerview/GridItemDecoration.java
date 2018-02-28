package github.danielhan.sample.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * @author DanielHan
 * @date 2018/2/26
 */

public class GridItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};
    private static final String TAG = "LinearItemDecoration";
    private Drawable mDivider;
    private int mNumColumns, horizontalDividerWidth, verticalDividerWidth;


    public GridItemDecoration(Context context, int horizontalDividerWidth, int verticalDividerWidth, int numColumns) {
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        if (mDivider == null) {
            Log.w(TAG, "@android:attr/listDivider was not set in the theme used for this "
                    + "DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        a.recycle();
        mNumColumns = numColumns;
        this.horizontalDividerWidth = horizontalDividerWidth;
        this.verticalDividerWidth = verticalDividerWidth;
    }

    /**
     * Draws horizontal and/or vertical dividers onto the parent RecyclerView.
     *
     * @param canvas The {@link Canvas} onto which dividers will be drawn
     * @param parent The RecyclerView onto which dividers are being added
     * @param state  The current RecyclerView.State of the RecyclerView
     */
    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        drawHorizontalDividers(canvas, parent);
        drawVerticalDividers(canvas, parent);
    }

    /**
     * Determines the size and location of offsets between items in the parent
     * RecyclerView.
     *
     * @param outRect The {@link Rect} of offsets to be added around the child view
     * @param view    The child view to be decorated with an offset
     * @param parent  The RecyclerView onto which dividers are being added
     * @param state   The current RecyclerView.State of the RecyclerView
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        int column = position % mNumColumns;
        int left = horizontalDividerWidth * column / mNumColumns;
        int right = horizontalDividerWidth * (mNumColumns - 1 - column) / mNumColumns;
        int top = 0;
        if (position >= mNumColumns) {
            top = verticalDividerWidth;
        }
        outRect.set(left,top,right,0);
        Log.e("getItemOffsets", "position:" + position + ",top:" + outRect.top);
    }

    /**
     * Adds horizontal dividers to a RecyclerView with a GridLayoutManager or its
     * subclass.
     *
     * @param canvas The {@link Canvas} onto which dividers will be drawn
     * @param parent The RecyclerView onto which dividers are being added
     */
    private void drawHorizontalDividers(Canvas canvas, RecyclerView parent) {
//        int childCount = parent.getChildCount();
//        int rowCount = childCount / mNumColumns + (childCount % mNumColumns == 0 ? 0 : 1);
//        int lastRowChildCount = childCount % mNumColumns;
//
//        for (int i = 0; i < mNumColumns; i++) {
//            int lastRowChildIndex;
//            if (i < lastRowChildCount) {
//                lastRowChildIndex = i + ((rowCount-1) * mNumColumns);
//            } else {
//                lastRowChildIndex = i + ((rowCount - 2) * mNumColumns);
//            }
//
//            View firstRowChild = parent.getChildAt(i);
//            View lastRowChild = parent.getChildAt(lastRowChildIndex);
//
//            int dividerTop = firstRowChild.getTop();
//            int dividerRight = firstRowChild.getLeft();
//            int dividerLeft = dividerRight - horizontalDividerWidth;
//            int dividerBottom = lastRowChild.getBottom();
//
//            mDivider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom);
//            mDivider.draw(canvas);
//        }

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            int dividerTop = child.getTop();
            int dividerRight = child.getLeft();
            int dividerLeft = dividerRight - horizontalDividerWidth;
            int dividerBottom = child.getBottom();
            mDivider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom);
            mDivider.draw(canvas);
        }
    }

    /**
     * Adds vertical dividers to a RecyclerView with a GridLayoutManager or its
     * subclass.
     *
     * @param canvas The {@link Canvas} onto which dividers will be drawn
     * @param parent The RecyclerView onto which dividers are being added
     */
    private void drawVerticalDividers(Canvas canvas, RecyclerView parent) {
//        int childCount = parent.getChildCount();
//        int rowCount = childCount / mNumColumns + (childCount % mNumColumns == 0 ? 0 : 1);
//        int rightmostChildIndex;
//        for (int i = 0; i < rowCount; i++) {
//            if (i == rowCount - 1) {
//                rightmostChildIndex = parent.getChildCount() - 1;
//            } else {
//                rightmostChildIndex = (i * mNumColumns) + mNumColumns - 1;
//            }
//
//            View leftmostChild = parent.getChildAt(i * mNumColumns);
//            View rightmostChild = parent.getChildAt(rightmostChildIndex);
//
//            int dividerLeft = leftmostChild.getLeft();
//            int dividerBottom = leftmostChild.getTop();
//            int dividerTop = dividerBottom - verticalDividerWidth;
//            int dividerRight = rightmostChild.getRight();
//
//            mDivider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom);
//            mDivider.draw(canvas);
//        }

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            int dividerLeft = child.getLeft() - horizontalDividerWidth;
            int dividerBottom = child.getTop();
            int dividerTop = dividerBottom - verticalDividerWidth;
            int dividerRight = child.getRight();
            mDivider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom);
            mDivider.draw(canvas);
        }
    }
}
