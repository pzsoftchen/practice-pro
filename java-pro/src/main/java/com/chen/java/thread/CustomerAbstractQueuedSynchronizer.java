package com.chen.java.thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @program: practice-pro
 * @class：CustomerAbstractQueuedSynchronizer
 * @description: AbstractQueuedSynchronizer
 * @author: pzsoftchen
 * @create: 06/29/2020 17:24:39
 **/
public class CustomerAbstractQueuedSynchronizer extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }
}
