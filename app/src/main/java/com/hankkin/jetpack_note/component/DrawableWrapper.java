
/*
 * MIT License
 *
 * Copyright (c) 2018 Justson
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.hankkin.jetpack_note.component;

import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * @author cenxiaozhong
 * @date 2018/2/23
 * @since 1.0.0
 */
public class DrawableWrapper extends Drawable {

    private final Drawable mWrapped;

    public DrawableWrapper(@NonNull Drawable drawable) {
        mWrapped = drawable;
    }

    public Drawable getWrappedDrawable() {
        return mWrapped;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        mWrapped.draw(canvas);
    }

    @Override
    public int getChangingConfigurations() {
        return mWrapped.getChangingConfigurations();
    }

    @Override
    public ConstantState getConstantState() {
        return mWrapped.getConstantState();
    }

    @Override
    public Drawable getCurrent() {
        return mWrapped.getCurrent();
    }

    @Override
    public int getIntrinsicHeight() {
        return mWrapped.getIntrinsicHeight();
    }

    @Override
    public int getIntrinsicWidth() {
        return mWrapped.getIntrinsicWidth();
    }

    @Override
    public int getMinimumHeight() {
        return mWrapped.getMinimumHeight();
    }

    @Override
    public int getMinimumWidth() {
        return mWrapped.getMinimumWidth();
    }

    @Override
    public int getOpacity() {
        return mWrapped.getOpacity();
    }

    @Override
    public boolean getPadding(Rect padding) {
        return mWrapped.getPadding(padding);
    }

    @Override
    public int[] getState() {
        return mWrapped.getState();
    }

    @Override
    public Region getTransparentRegion() {
        return mWrapped.getTransparentRegion();
    }

    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs)
            throws XmlPullParserException, IOException {
        mWrapped.inflate(r, parser, attrs);
    }

    @Override
    public boolean isStateful() {
        return mWrapped.isStateful();
    }

    @Override
    public void jumpToCurrentState() {
        mWrapped.jumpToCurrentState();
    }

    @Override
    public Drawable mutate() {
        return mWrapped.mutate();
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        mWrapped.setAlpha(i);
    }

    @Override
    public void scheduleSelf(Runnable what, long when) {
        mWrapped.scheduleSelf(what, when);
    }

    @Override
    public void setChangingConfigurations(int configs) {
        mWrapped.setChangingConfigurations(configs);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        mWrapped.setColorFilter(colorFilter);
    }

    @Override
    public void setColorFilter(int color, PorterDuff.Mode mode) {
        mWrapped.setColorFilter(color, mode);
    }

    @Override
    public void setFilterBitmap(boolean filter) {
        mWrapped.setFilterBitmap(filter);
    }

    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        return mWrapped.setVisible(visible, restart);
    }

    @Override
    public void unscheduleSelf(Runnable what) {
        mWrapped.unscheduleSelf(what);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        mWrapped.setBounds(bounds);
    }

    @Override
    protected boolean onLevelChange(int level) {
        return mWrapped.setLevel(level);
    }

    @Override
    protected boolean onStateChange(int[] state) {
        return mWrapped.setState(state);
    }
}
