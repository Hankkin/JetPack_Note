# JetPack_Note
Jetpack note

> JetpackNote 是一款基于谷歌官方组件Jetpack开发的笔记项目，项目中包含了对各大组件的源码分析、Demo使用：Navigation、Lifecycles、Paging、LiveData、ViewModel等...
>         \n项目使用Kotlin语言进行编写，依赖库截止代码编写时为最新版本，的几篇源码分析我们分别对`Navigation`、`Lifecycles`、`ViewModel`、`LiveData`、进行了分析，也对**JetPack**有了更深入的了解。

如果你对Jetpack组件有了解或者想对源码有更深入的了解，请看我之前的几篇文章：



[1. Jetpack源码解析---看完你就知道Navigation是什么了？](https://juejin.im/post/5d1202fc6fb9a07ef90ca7a1)

[2. Jetpack源码解析---Navigation为什么切换Fragment会重绘？](https://juejin.im/post/5d12cfea6fb9a07ed4411040)

[3. Jetpack源码解析---用Lifecycles管理生命周期](https://juejin.im/post/5d15bbb86fb9a07f03574e56)

[4. Jetpack源码解析—LiveData的使用及工作原理](https://juejin.im/post/5d247b036fb9a07eee5ef3df)

[5. Jetpack源码解析---ViewModel基本使用及源码解析](https://juejin.im/post/5d2d4172e51d4510835e0346)

[6. Jetpack---Paging你知道怎样上拉加载吗？](https://juejin.im/user/55dea68160b291d79422c1bb)





**下载链接：**



![](http://ww2.sinaimg.cn/large/006y8mN6ly1g6teej3gy1j305k05kmxm.jpg)







# 1. 背景

在我的**Jetpack_Note**系列中，对每一篇的分析都有相对应的代码片段及使用，我把它做成了一个APP，目前功能还不完善，代码我也上传到了GitHub上，参考了官方的Demo以及目前网上的一些文章，有兴趣的小伙伴可以看一下，别忘了给个Star。

[https://github.com/Hankkin/JetPack_Note](https://github.com/Hankkin/JetPack_Note)

我们先看一下效果吧：



![](http://ww3.sinaimg.cn/large/006y8mN6ly1g6tbzuet1dg308w0j1gun.gif)



# 2. JetpackNote是什么？

> JetpackNote 是一款基于谷歌官方组件Jetpack开发的笔记项目，项目中包含了对各大组件的源码分析、Demo使用：Navigation、Lifecycles、Paging、LiveData、ViewModel等...项目使用Kotlin语言进行编写，依赖库截止代码编写时为最新版本。



Jetpack是什么想必大家对它都已经有了基本的了解了，官方介绍以及官方文档：

[https://developer.android.com/jetpack](https://developer.android.com/jetpack)

Jetpack 是一套库、工具和指南，可帮助开发者更轻松地编写优质应用。这些组件可帮助您遵循最佳做法、让您摆脱编写样板代码的工作并简化复杂任务，以便您将精力集中放在所需的代码上。

Jetpack 包含与平台 API 解除捆绑的 [androidx.*](https://developer.android.com/jetpack/androidx) 软件包库。这意味着，它可以提供向后兼容性，且比 Android 平台的更新频率更高，以此确保您始终可以获取最新且最好的 Jetpack 组件版本。



![](http://ww2.sinaimg.cn/large/006y8mN6ly1g6tcu5ar4pj30xi0u04gg.jpg)



# 3. 为什么写JetpackNote？

说的简单些：就是为了记录自己的一个学习过程....

我为什么要学习Jetpack呢？想尝试一种新的架构方式，从我开始工作到现在，经历过了最初的MVC、**MVP**[MVP-todo、The-MVP...]以及各式各样的MVP]、**MVVM**、**Clean**等，当然我并没有所有的架构都用到过，每个项目基于自己的项目特点以及需求的迭代都会出现一套基于开发者所设计的架构模式，分层、组件化、模块化，我相信每一种设计都是基于项目所在的场景的。即使谷歌官方推荐使用todo-mvp使用契约类....，但终究那不能适合所有项目场景。但是**Jetpack**，它是一套组件、工具和指导；是谷歌正式推出的一整套用来构建APP开发的组件。



![](http://ww3.sinaimg.cn/large/006y8mN6ly1g6tds8lt63j32400u0jze.jpg)



在Android Developers官网上，Jetpack作为一个Tab和Kotlin、Android Studio等一样的地位也同样占据了一个模块，Jetpack里目前包含的内容，未来想必也是谷歌大力维护和扩展的东西，所以我打算对Jetpack深入学习一番，其实Google Play商店中很多APP都已经开始使用Android Jetpack了，国内目前也有一些公司在使用了，虽然我很少听到，但是就目前关于Jetpack的一个帖子上面的内容经常会有人提到。这只是我对Jetpack学习的一些个人看法和想法啊，觉得有必要的你可以研究一下，反正到最后没有亏吃，是吧....



# 4. JetpackNote包含哪些内容

## 4.1 Navigation



[1. Jetpack源码解析---看完你就知道Navigation是什么了？](https://juejin.im/post/5d1202fc6fb9a07ef90ca7a1)

[2. Jetpack源码解析---Navigation为什么切换Fragment会重绘？](https://juejin.im/post/5d12cfea6fb9a07ed4411040)



<img src="http://ww4.sinaimg.cn/large/006y8mN6ly1g6te5x7pntj30u01t040f.jpg" style="zoom:20%;" />

## 4.2 Lifecycles



[3. Jetpack源码解析---用Lifecycles管理生命周期](https://juejin.im/post/5d15bbb86fb9a07f03574e56)

在Lifecycles模块，我通过一个悬浮窗模拟控制台输出，来监听定位权限的日志....



<img src="http://ww1.sinaimg.cn/large/006y8mN6ly1g6te52prx6j30u01t0dhz.jpg" style="zoom:33%;" />

## 4.3 LiveData



在LiveData模块，通过生命周期观察LiveData的值，并将它打印在控制台中，点击 开始观察数据 按钮，通过演示生命周期函数，返回桌面或者进入后台，查看LiveData对象的值。
Map转换则演示通过转换存储在LiveData对象中的值，并向下传递转换后的数据。在此Demo中通过点击Map按钮增加UserId，驱动LiveDataViewModel中的userBean来改变，最后展示在TextView中



[4. Jetpack源码解析—LiveData的使用及工作原理](https://juejin.im/post/5d247b036fb9a07eee5ef3df)



<img src="http://ww4.sinaimg.cn/large/006y8mN6ly1g6te80mruvj30u01t077l.jpg" style="zoom:33%;" />

## 4.4 ViewModel

在ViewModel模块，屏幕中央为一个计时器，通过使用ViewModel存储计时器的值，将屏幕方向发生改变后，数据仍然存在不会销毁。
通过点击 查看Fragment共享Demo 可以查看两个Fragment共享了同一个ViewModel中的SeekBar的值。



[5. Jetpack源码解析---ViewModel基本使用及源码解析](https://juejin.im/post/5d2d4172e51d4510835e0346)



<img src="http://ww3.sinaimg.cn/large/006y8mN6ly1g6te9v6h0rj30u01t0dih.jpg" style="zoom:33%;" />

## 4.5 Paging



[6. Jetpack---Paging你知道怎样上拉加载吗？](https://juejin.im/post/5d63f620f265da03970bc76d)



<img src="http://ww4.sinaimg.cn/large/006y8mN6ly1g6teba99vsj30u01t0tak.jpg" style="zoom:33%;" />

其他还有Room、WorkManager也基本有用到，但是还没有详细进行分析....这就是关于JetpackNote的整体内容，如果不当地方还请指正....



# 5. 结尾

**Github**
[https://github.com/Hankkin/JetPack_Note](https://github.com/Hankkin/JetPack_Note)



**下载链接：**



![](http://ww2.sinaimg.cn/large/006y8mN6ly1g6teej3gy1j305k05kmxm.jpg)




