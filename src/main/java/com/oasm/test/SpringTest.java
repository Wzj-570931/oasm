package com.oasm.test;

import com.oasm.annotation.Entity;
import com.oasm.config.ConfigStart;
import com.oasm.config.MybatisConfig;
import com.oasm.dao.DbMapper;
import com.oasm.dao.Factory;
import com.oasm.dao.HumanFactory;
import com.oasm.service.MyFactoryBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.*;

public class SpringTest {

    int a;
    char b;
    int arr[];
    String c;

    /*@Autowired
    Factory factory;*/
    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigStart.class);
        Factory bean = applicationContext.getBean(Factory.class);
        //ClassPathXmlApplicationContext
        bean.getName("123");
        /*Class<? extends Factory> clazz = applicationContext.getBean(Factory.class).getClass();
        Method[] methods = clazz.getMethods();
        List<Method> list = Arrays.asList(methods);
        list.parallelStream().forEach((Method method) -> {
            boolean annotationPresent = method.isAnnotationPresent(Entity.class);
            if (annotationPresent){
                Entity annotation = method.getAnnotation(Entity.class);
                System.out.println(annotation.value());
            }
        });

        Entity entity = clazz.getAnnotation(Entity.class);
        boolean annotationPresent = clazz.isAnnotationPresent(Entity.class);
        if (annotationPresent){
            String value = entity.value();
            String name = entity.name();
            System.out.println("value="+value+",name="+name);
        }*/

        Class<? extends Factory> aClass = applicationContext.getBean(Factory.class).getClass();
        aClass.isAnnotationPresent(Entity.class);
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(ConfigStart.class);
        Factory factory = (Factory) acac.getBean("humanFactory");
        //Factory factory = acac.getBean(HumanFactory.class);
        System.out.println(factory instanceof HumanFactory);
        factory.getName("123");
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(ConfigStart.class);
        Factory factory = (Factory) acac.getBean("testDao");
        factory.getName("3434");
    }

    @Test
    public void test5() {
        HashMap hashMap = new HashMap(1000, 0.8f);
        System.out.println(a);
        System.out.println(b);
        System.out.println(arr);
        System.out.println(c);
    }

    @Test
    public void test6() {
        /*String[] arrStr = new String[10];
        for (int i = 0; i < arrStr.length; i++) {
            System.out.println(arrStr[i]);
        }
        int[] arrInt = new int[10];
        for (int i = 0; i < arrInt.length ; i++) {
            System.out.println(arrInt[i]);
        }*/
        Integer integer1 = 120;
        Integer integer2 = 120;
        System.out.println(integer1 == integer2);

        int num9 = 100;
        Integer num10 = new Integer(100);
        Integer num11 = 100;
        double d = 100;
        System.out.println("num9==num10 " + (num9 == num10));
        System.out.println("num9==num11 " + (num9 == num11));

        boolean a = true;

        ((SpringTest) null).say();
    }

    public static void say() {
        System.out.println("1111");
    }

    @Test
    public void test4() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigStart.class);
        Object factory = applicationContext.getBean("&factory");
        System.out.println(factory instanceof MyFactoryBean);
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 10,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //pool.allowCoreThreadTimeOut(true);

        Callable callable = () -> {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("call 方法调用了");
            return "111";
        };


        Future future = executorService.submit(callable);
        future.cancel(true);
        future.get();
        System.out.println(future.get(2, TimeUnit.SECONDS));
        /*System.out.println("2222");
        while (!future.isDone()){
            System.out.println(future.get());
        }*/
        /*for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName()+"执行");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        while (pool.getQueue().size()>0){
            TimeUnit.SECONDS.sleep(1);
            System.out.println("当前线程池的数量是："+pool.getQueue().size());
        }

        Executors.newFixedThreadPool(3);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        //pool.submit();*/
    }

    @Test
    public void test7() {
        /*char a = 'a';
        System.out.println(a+10);
        int b = (int)12.05;*/
        //System.out.println(test8());

        //String a = 3.9+"";
        /*System.out.println(a);
        a%=2;
        System.out.println(a);*/
        //switch (a){}
        String a[] = new String[5];
        for (int i = 0; i < 5; i++) {
            a[i++] = "";
        }
        new HashMap<>().put(null, null);
        new TreeMap<>().put(0, null);
        System.out.println(a);
    }


    @Test
    public void test9() {
    }

    public int test8() {
        try {
            int a = 3 / 4;
            return 1;
        } finally {
            return 2;
        }
    }

    @Test
    public void test10() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MybatisConfig.class);
        System.out.println(context.getClassLoader());
        String str = new String("123");
        System.out.println(str.getClass().getClassLoader());
        DbMapper dbMapper = context.getBean(DbMapper.class);
        System.out.println(dbMapper.getApprovalId(4019782));
    }

    @Test
    public void test11() {
        /*String string = new String("str");
        System.out.println(string.getClass().getClassLoader());
        TestDao testdao = new TestDao();
        System.out.println(testdao.getClass().getClassLoader());*/
        /*System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());*/
    }
}
