/*
 * Copyright (C) 2017 zhengjun, fanwe (http://www.fanwe.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fanwe.library.span.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.fanwe.library.span.SDSpannableStringBuilder;

/**
 * Created by Administrator on 2017/7/13.
 */

public abstract class SDSpannableTextView extends TextView
{
    public SDSpannableTextView(Context context)
    {
        super(context);
    }

    public SDSpannableTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    public void setText(CharSequence text, BufferType type)
    {
        if (text != null)
        {
            SDSpannableStringBuilder sb = null;
            if (text instanceof SDSpannableStringBuilder)
            {
                sb = (SDSpannableStringBuilder) text;
            } else
            {
                sb = new SDSpannableStringBuilder();
                sb.append(text);
            }
            onProcessSpannableStringBuilder(sb);
            text = sb;
        }

        super.setText(text, type);
    }

    protected abstract void onProcessSpannableStringBuilder(SDSpannableStringBuilder builder);
}
