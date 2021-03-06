/*
 * Copyright 2017 jiajunhui<junhui_jia@163.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.google.android.exoplayer2.render;

import android.view.View;

import com.google.android.exoplayer2.SimpleExoPlayer;


/**
 * Created by Taurus on 2017/11/19.
 * <p>
 * frame rendering view,
 * using the method can refer to VideoPlayerView
 */
public interface IRender {
    /**
     * Sets visibility.
     *
     * @param visibility the visibility
     */
    void setVisibility(int visibility);

    /**
     * Sets render callback.
     *
     * @param renderCallback the render callback
     */
    void setRenderCallback(IRenderCallback renderCallback);

    /**
     * update video rotation, such as some video maybe rotation 90 degree.
     *
     * @param degree the degree
     */
    void setVideoRotation(int degree);

    /**
     * Sets video sample aspect ratio.
     *
     * @param videoSarNum the video sar num
     * @param videoSarDen the video sar den
     */
    void setVideoSampleAspectRatio(int videoSarNum, int videoSarDen);


    /**
     * update video show aspect ratio
     * <p>
     * see also
     * {@link AspectRatio#AspectRatio_16_9}
     * {@link AspectRatio#AspectRatio_4_3}
     * {@link AspectRatio#AspectRatio_FIT_PARENT}
     * {@link AspectRatio#AspectRatio_FILL_PARENT}
     * {@link AspectRatio#AspectRatio_MATCH_PARENT}
     * {@link AspectRatio#AspectRatio_ORIGIN}
     *
     * @param aspectRatio aspectRatio
     */
    void updateAspectRatio(@AspectRatio.ResizeMode int aspectRatio);

    /**
     * get video show aspect ratio
     *
     * @return the resize mode
     */
    @AspectRatio.ResizeMode
    int getResizeMode();

    /**
     * update video size ,width and height.
     *
     * @param videoWidth  videoWidth
     * @param videoHeight videoHeight
     */
    void updateVideoSize(int videoWidth, int videoHeight);

    /**
     * Gets render view.
     *
     * @return the render view
     */
    View getRenderView();

    /**
     * release render,the render will become unavailable
     */
    void release();


    /**
     * IRenderHolder is responsible for associate the decoder with rendering views.
     * <p>
     * see also
     */
    interface IRenderHolder {
        /**
         * Bind player.
         *
         * @param player the player
         */
        void bindPlayer(SimpleExoPlayer player);
    }

    /**
     * see also
     * {@link RenderSurfaceView.IRenderCallback}
     * {@link RenderTextureView.IRenderCallback}
     */
    interface IRenderCallback {
        /**
         * On surface created.
         *
         * @param renderHolder the render holder
         * @param width        the width
         * @param height       the height
         */
        void onSurfaceCreated(IRenderHolder renderHolder, int width, int height);

        /**
         * On surface changed.
         *
         * @param renderHolder the render holder
         * @param format       the format
         * @param width        the width
         * @param height       the height
         */
        void onSurfaceChanged(IRenderHolder renderHolder, int format, int width, int height);

        /**
         * On surface destroy.
         *
         * @param renderHolder the render holder
         */
        void onSurfaceDestroy(IRenderHolder renderHolder);
    }

}
