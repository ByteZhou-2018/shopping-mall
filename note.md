### 简单记录一下android.support.v4 jar包与androidx不兼容的问题

```shell
Execution failed for task ':app:checkDebugDuplicateClasses'.
> A failure occurred while executing com.android.build.gradle.internal.tasks.CheckDuplicatesRunnable
> Duplicate class android.support.v4.app.INotificationSideChannel found in modules core-1.3.2-runtime (androidx.core:core:1.3.2) and support-compat-25.3.1-runtime (com.android.support:support-compat:25.3.1)
Duplicate class android.support.v4.app.INotificationSideChannel$Stub found in modules core-1.3.2-runtime (androidx.core:core:1.3.2) and support-compat-25.3.1-runtime (com.android.support:support-compat:25.3.1)
Duplicate class android.support.v4.app.INotificationSideChannel$Stub$Proxy found in modules core-1.3.2-runtime (androidx.core:core:1.3.2) and support-compat-25.3.1-runtime (com.android.support:support-compat:25.3.1)
Duplicate class android.support.v4.os.IResultReceiver found in modules core-1.3.2-runtime (androidx.core:core:1.3.2) and support-compat-25.3.1-runtime (com.android.support:support-compat:25.3.1)
Duplicate class android.support.v4.os.IResultReceiver$Stub found in modules core-1.3.2-runtime (androidx.core:core:1.3.2) and support-compat-25.3.1-runtime (com.android.support:support-compat:25.3.1)
Duplicate class android.support.v4.os.IResultReceiver$Stub$Proxy found in modules core-1.3.2-runtime (androidx.core:core:1.3.2) and support-compat-25.3.1-runtime (com.android.support:support-compat:25.3.1)
Duplicate class android.support.v4.os.ResultReceiver found in modules core-1.3.2-runtime (androidx.core:core:1.3.2) and support-compat-25.3.1-runtime (com.android.support:support-compat:25.3.1)
Duplicate class android.support.v4.os.ResultReceiver$1 found in modules core-1.3.2-runtime (androidx.core:core:1.3.2) and support-compat-25.3.1-runtime (com.android.support:support-compat:25.3.1)
Duplicate class android.support.v4.os.ResultReceiver$MyResultReceiver found in modules core-1.3.2-runtime (androidx.core:core:1.3.2) and support-compat-25.3.1-runtime (com.android.support:support-compat:25.3.1)
Duplicate class android.support.v4.os.ResultReceiver$MyRunnable found in modules core-1.3.2-runtime (androidx.core:core:1.3.2) and support-compat-25.3.1-runtime (com.android.support:support-compat:25.3.1)
* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.

```

解决办法：androidx是对android.support.v4和v7的合并升级版，如果AndroidStudio升级或采用了3.5版本，默认提供的androidx库，此时需要将android.support.v4的jar包移除，并把所有的相关import修正为androidx下的对应类



### butterknife无法匹配的问题

```shell
Execution failed for task ':app:compileDebugJavaWithJavac'.
> Could not resolve all files for configuration ':app:debugAnnotationProcessorClasspath'.
   > Failed to transform butterknife-compiler-8.8.1.jar (com.jakewharton:butterknife-compiler:8.8.1) to match attributes {artifactType=processed-jar, org.gradle.category=library, org.gradle.libraryelements=jar, org.gradle.status=release, org.gradle.usage=java-runtime}.
      > Execution failed for JetifyTransform: C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\com.jakewharton\butterknife-compiler\8.8.1\b2f4505a1babb7b7c11abbbf8ea4c90b18c3aeac\butterknife-compiler-8.8.1.jar.
         > Failed to transform 'C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\com.jakewharton\butterknife-compiler\8.8.1\b2f4505a1babb7b7c11abbbf8ea4c90b18c3aeac\butterknife-compiler-8.8.1.jar' using Jetifier. Reason: AmbiguousStringJetifierException, message: The given artifact contains a string literal with a package reference 'android.support.v4.content' that cannot be safely rewritten. Libraries using reflection such as annotation processors need to be updated manually to add support for androidx.. (Run with --stacktrace for more details.)
           This is a known exception, and Jetifier won't be able to jetify this library.
           Suggestions:
            - If you believe this library doesn't need to be jetified (e.g., if it already supports AndroidX, or if it doesn't use support libraries/AndroidX at all), add android.jetifier.ignorelist = {comma-separated list of regular expressions (or simply names) of the libraries that you don't want to be jetified} to the gradle.properties file.
            - If you believe this library needs to be jetified (e.g., if it uses old support libraries and breaks your app if it isn't jetified), contact the library's authors to update this library to support AndroidX and use the supported version once it is released.
           If you need further help, please leave a comment at https://issuetracker.google.com/issues/140747218.

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
```

该问题最终排查的结果是，引入的support.v4.jar被删除，导致该包缺少相关依赖，无法build项目，

解决方案：

```shell
 implementation 'com.jakewharton:butterknife:10.2.3'
    annotationProcessor 'com.jakewharton:butterknife-compiler:10.2.3'
```

将butteknife升级到最新版本就可以直接解决该问题了

2023年4月14日