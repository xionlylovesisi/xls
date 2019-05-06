package com.xlm.stream;

import com.alibaba.fastjson.JSON;
import com.xlm.common.util.LogUtils;
import com.xlm.stream.data.Data;
import com.xlm.stream.data.PersonModel;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author xls
 * @date 2019-04-16
 * @description filter
 */
@Slf4j
public class Stream {
    private static List<PersonModel> getData() {
        return Data.getData();
    }

    /**
     * 过滤性别
     *
     * @param sex
     */
    public static void filterSex(String sex) {
        List<PersonModel> data = getData();
        LogUtils.info(log, "--->[filterSex]:**INFO**old-->start:{}!", System.currentTimeMillis());
        List<PersonModel> temp = new ArrayList<>();
        for (PersonModel datum : data) {
            if (datum.getSex().equals(sex)) {
                temp.add(datum);
            }
        }
        LogUtils.info(log, "--->[filterSex]:**[INFO]**[old result:{}]!", JSON.toJSONString(temp));
        LogUtils.info(log, "--->[filterSex]:**INFO**old-->end:{}!", System.currentTimeMillis());
        LogUtils.info(log, "--->[filterSex]:**INFO**new-->start:{}!", System.currentTimeMillis());
        List<PersonModel> newFilterResult = data.stream().filter(personModel -> personModel.getSex().equals(sex)).collect(Collectors.toList());
        LogUtils.info(log, "--->[filterSex]:**[INFO]**[new result:{}]!", JSON.toJSONString(newFilterResult));
        LogUtils.info(log, "--->[filterSex]:**INFO**new-->end:{}!", System.currentTimeMillis());

    }

    public static void filterSexAndAge(String sex, Integer lessThanAge) {
        List<PersonModel> data = getData();
        LogUtils.info(log, "--->[filterSexAndAge]:**INFO**old-->start:{}!", System.currentTimeMillis());
        List<PersonModel> temp = new ArrayList<>();
        for (PersonModel datum : data) {
            if (datum.getSex().equals(sex) && datum.getAge() < lessThanAge) {
                temp.add(datum);
            }
        }
        LogUtils.info(log, "--->[filterSexAndAge]:**[INFO]**[old result:{}]!", JSON.toJSONString(temp));
        LogUtils.info(log, "--->[filterSexAndAge]:**INFO**-->end:{}!", System.currentTimeMillis());
        LogUtils.info(log, "--->[filterSexAndAge]:**INFO**new-->start:{}!", System.currentTimeMillis());
        List<PersonModel> newFilterResult = data.stream().filter(personModel -> personModel.getSex().equals(sex) && personModel.getAge() < lessThanAge).collect(Collectors.toList());
        LogUtils.info(log, "--->[filterSexAndAge]:**[INFO]**[new result:{}]!", JSON.toJSONString(newFilterResult));
        LogUtils.info(log, "--->[filterSexAndAge]:**INFO**new-->end:{}!", System.currentTimeMillis());

    }

    public static void getUserNameList() {
        List<PersonModel> data = getData();
        LogUtils.info(log, "--->[getUserNameList]:**INFO**old-->start:{}!", System.currentTimeMillis());
        List<String> oldResult = new ArrayList<>();
        for (PersonModel datum : data) {
            oldResult.add(datum.getName());
        }
        LogUtils.info(log, "--->[getUserNameList]:**[INFO]**[old result:{}]!", JSON.toJSONString(oldResult));
        LogUtils.info(log, "--->[getUserNameList]:**INFO**-->end:{}!", System.currentTimeMillis());


        LogUtils.info(log, "--->[getUserNameList]:**INFO**new1-->start:{}!", System.currentTimeMillis());
        List<String> new1 = data.stream().map(personModel -> personModel.getName()).collect(Collectors.toList());
        LogUtils.info(log, "--->[getUserNameList]:**[INFO]**[new1 result:{}]!", JSON.toJSONString(new1));
        LogUtils.info(log, "--->[getUserNameList]:**INFO**new1-->end:{}!", System.currentTimeMillis());


        LogUtils.info(log, "--->[getUserNameList]:**INFO**new2-->start:{}!", System.currentTimeMillis());
        List<String> new2 = data.stream().map(PersonModel::getName).collect(Collectors.toList());
        LogUtils.info(log, "--->[getUserNameList]:**[INFO]**[new2 result:{}]!", JSON.toJSONString(new2));
        LogUtils.info(log, "--->[getUserNameList]:**INFO**new2-->end:{}!", System.currentTimeMillis());


        LogUtils.info(log, "--->[getUserNameList]:**INFO**new3-->start:{}!", System.currentTimeMillis());
        List<String> new3 = data.stream().map(personModel -> {
            LogUtils.info(log, "--->[getUserNameList]:**[INFO]**[new3-->name:{}]!", personModel.getName());
            return personModel.getName();
        }).collect(Collectors.toList());
        LogUtils.info(log, "--->[getUserNameList]:**[INFO]**[new3 result:{}]!", JSON.toJSONString(new3));
        LogUtils.info(log, "--->[getUserNameList]:**INFO**new3-->end:{}!", System.currentTimeMillis());

    }

    public static void flatMapString() {
        List<PersonModel> data = getData();
        LogUtils.info(log, "--->[faltMapString]:**INFO**start:{}!", System.currentTimeMillis());
        List<String> flatMap1 = data.stream().flatMap(personModel -> Arrays.stream(personModel.getName().split(" "))).collect(Collectors.toList());

        LogUtils.info(log, "--->[faltMapString]:**[INFO]**[flatMap1:{}]!", JSON.toJSONString(flatMap1));


        List<java.util.stream.Stream<String>> map = data.stream().map(personModel -> Arrays.stream(personModel.getName().split(" "))).collect(Collectors.toList());
        LogUtils.info(log, "--->[faltMapString]:**[INFO]**[map:{}]!", JSON.toJSONString(map));


        List<String> flatMapAndMap1 = data.stream().map(personModel -> personModel.getName().split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
        LogUtils.info(log, "--->[faltMapString]:**[INFO]**[flatMapAndMap1:{}]!", JSON.toJSONString(flatMapAndMap1));


        List<String> flatMapAndMap2 = data.stream().map(personModel -> personModel.getName().split(" ")).flatMap(strings -> Arrays.stream(strings)).collect(Collectors.toList());

        LogUtils.info(log, "--->[faltMapString]:**[INFO]**[flatMapAndMap2:{}]!", JSON.toJSONString(flatMapAndMap2));


        LogUtils.info(log, "--->[faltMapString]:**INFO**end:{}!", System.currentTimeMillis());

    }

    public static void reduce() {
        LogUtils.info(log, "--->[reduce]:**INFO**start:{}!", System.currentTimeMillis());

        // 累加,初始化值为10
        Integer reduce = java.util.stream.Stream.of(1, 2, 3, 4).reduce(10, (count, item) -> {
            LogUtils.info(log, "--->[reduce]:**[INFO]**[count:{}]!", count);
            LogUtils.info(log, "--->[reduce]:**[INFO]**[item:{}]!", item);
            return count + item;
        });
        LogUtils.info(log, "--->[reduce]:**[INFO]**[reduce:{}]!", reduce);

        Integer reduce1 = java.util.stream.Stream.of(1, 2, 3, 4).reduce(0, (x, y) -> x + y);

        LogUtils.info(log, "--->[reduce]:**[INFO]**[reduce1:{}]!", reduce1);

        String reduce2 = java.util.stream.Stream.of("1", "2", "3", "4").reduce("0", (x, y) -> {
            LogUtils.info(log, "--->[reduce]:**[INFO]**[x:{}]!", x);
            LogUtils.info(log, "--->[reduce]:**[INFO]**[y:{}]!", y);
            return x + "," + y;
        });

        LogUtils.info(log, "--->[reduce]:**[INFO]**[reduce2:{}]!", reduce2);

        LogUtils.info(log, "--->[reduce]:**INFO**end:{}!", System.currentTimeMillis());

    }

    public static void collect() {
        LogUtils.info(log, "--->[collect]:**INFO**start:{}!", System.currentTimeMillis());
        List<PersonModel> data = getData();
        // toList
        List<String> toList = data.stream().map(PersonModel::getName).collect(Collectors.toList());
        LogUtils.info(log, "--->[collect]:**[INFO]**[toList:{}]!", JSON.toJSONString(toList));

        // toSet
        Set<String> toSet = data.stream().map(PersonModel::getName).collect(Collectors.toSet());
        LogUtils.info(log, "--->[collect]:**[INFO]**[toSet:{}]!", JSON.toJSONString(toSet));
        // toMap
        Map<String, Integer> toMap = data.stream().collect(Collectors.toMap(PersonModel::getName, PersonModel::getAge));
        LogUtils.info(log, "--->[collect]:**[INFO]**[toMap:{}]!", JSON.toJSONString(toMap));
        Map<String, String> toMap1 = data.stream().collect(Collectors.toMap(o -> o.getName(), o -> {
            return o.toString() + "1";
        }));
        LogUtils.info(log, "--->[collect]:**[INFO]**[toMap1:{}]!", JSON.toJSONString(toMap1));
        //指定类型
        TreeSet<PersonModel> toSpecify = data.stream().collect(Collectors.toCollection(TreeSet::new));
        LogUtils.info(log, "--->[collect]:**[INFO]**[toSpecify:{}]!", JSON.toJSONString(toSpecify));
        // 分组
        Map<String, List<PersonModel>> groupingBySex = data.stream().collect(Collectors.groupingBy(o -> o.getSex()));
        LogUtils.info(log, "--->[collect]:**[INFO]**[groupingBySex:{}]!", JSON.toJSONString(groupingBySex));
        // 分隔
        String joining = data.stream().map(PersonModel::getName).collect(Collectors.joining(",", "{", "}"));
        LogUtils.info(log, "--->[collect]:**[INFO]**[joining:{}]!", joining);
        // 自定义
        List<String> customize = java.util.stream.Stream.of("1", "2", "3", "4", "5").collect(Collectors.reducing(new ArrayList<>(), o -> {
            LogUtils.info(log, "--->[collect]:**[INFO]**[mapper:{}]!", o);
            return Arrays.asList(o);
        }, (y, z) -> {
            LogUtils.info(log, "--->[collect]:**[INFO]**[binary operator y:{},z:{}]!", JSON.toJSONString(y), JSON.toJSONString(z));
            y.addAll(z);
            return y;
        }));
        LogUtils.info(log, "--->[collect]:**[INFO]**[customize:{}]!", JSON.toJSONString(customize));

        LogUtils.info(log, "--->[collect]:**INFO**end:{}!", System.currentTimeMillis());

    }


    public static void optional() {
        LogUtils.info(log, "--->[optional]:**INFO**start:{}!", System.currentTimeMillis());
        PersonModel personModel = new PersonModel();

        Optional<PersonModel> o = Optional.of(personModel);
        LogUtils.info(log, "--->[optional]:**INFO**of o:{}", o.isPresent()?o.get():"-");

        Optional<String> name = Optional.ofNullable(personModel.getName());
        LogUtils.info(log, "--->[optional]:**INFO**ofNullable name:{}", name.isPresent()?name.get():"-");
        Optional.ofNullable("test").ifPresent(s -> {
            LogUtils.info(log, "--->[optional]:**INFO**ifPresent not null s:{}", s);
        });
        LogUtils.info(log, "--->[optional]:**INFO**orElse 1:{}", Optional.ofNullable(null).orElse("-"));
        LogUtils.info(log, "--->[optional]:**INFO**orElse 2:{}", Optional.ofNullable("1").orElse("-"));
        LogUtils.info(log, "--->[optional]:**INFO**orElseGet 1:{}", Optional.ofNullable(null).orElseGet(() -> {
            return "orElseGet1";
        }));
        LogUtils.info(log, "--->[optional]:**INFO**orElseGet 2:{}", Optional.ofNullable("1").orElseGet(() -> {
            return "orElseGet2";
        }));
        LogUtils.info(log, "--->[optional]:**INFO**orElseThrow:{}", Optional.ofNullable("1").<RuntimeException>orElseThrow(() -> {
            throw new RuntimeException("orElseThrow");
        }));
        LogUtils.info(log, "--->[optional]:**INFO**multi level judge:{}", Optional.ofNullable(personModel).map(PersonModel::getName).map(String::length).isPresent());
        LogUtils.info(log,"--------分割线----------");
        List<PersonModel> data = getData();
        Optional.ofNullable(data).map(personModels -> personModels.stream().map(PersonModel::getName).collect(Collectors.toList())).ifPresent(strings -> System.out.println(strings));
        LogUtils.info(log, "--->[optional]:**INFO**end:{}!", System.currentTimeMillis());

    }
    public static void parallel(){
        LogUtils.info(log, "--->[parallel]:**INFO**start:{}!", System.currentTimeMillis());

        LogUtils.info(log, "--->[parallel]:**INFO**test list start!");
        int size = 10000000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        List<Integer> oldList = new ArrayList<>();
        //旧的方式
        long oldListStart = System.currentTimeMillis();
        for (Integer integer : list) {
            oldList.add(integer);
        }
        LogUtils.info(log, "--->[parallel]:**INFO**old list cost:{},size:{}!",System.currentTimeMillis()-oldListStart,oldList.size());
        //同步
        long newSyncListStart = System.currentTimeMillis();
        List<Integer> newSyncList = list.stream().collect(Collectors.toList());
        LogUtils.info(log, "--->[parallel]:**INFO**new sync list cost:{},size:{}!",System.currentTimeMillis()-newSyncListStart,newSyncList.size());
        long newParallelStart = System.currentTimeMillis();
        List<Integer> newParallelList = list.parallelStream().collect(Collectors.toList());
        LogUtils.info(log, "--->[parallel]:**INFO**new parallel list cost:{},size:{}!",System.currentTimeMillis()-newParallelStart,newParallelList.size());

        LogUtils.info(log, "--->[parallel]:**INFO**test set start!");
        Set<Integer> oldSet = new HashSet<>();
        long oldSetStart = System.currentTimeMillis();
        for (Integer integer : list) {
            oldSet.add(integer);
        }
        LogUtils.info(log, "--->[parallel]:**INFO**old set cost:{},size:{}!",System.currentTimeMillis()-oldSetStart,oldSet.size());
        long newSyncSetStart = System.currentTimeMillis();
        Set<Integer> newSyncSet = list.stream().collect(Collectors.toSet());
        LogUtils.info(log, "--->[parallel]:**INFO**new sync set cost:{},size:{}!",System.currentTimeMillis()-newSyncSetStart,newSyncSet.size());
        long newParallelSetStart = System.currentTimeMillis();
        Set<Integer> newParallelSet = list.parallelStream().collect(Collectors.toSet());
        LogUtils.info(log, "--->[parallel]:**INFO**new parallel set cost:{},size:{}!",System.currentTimeMillis()-newParallelSetStart,newParallelSet.size());
        LogUtils.info(log, "--->[parallel]:**INFO**end:{}!", System.currentTimeMillis());
    }

    public static void peek(){
        LogUtils.info(log, "--->[peek]:**INFO**start:{}!", System.currentTimeMillis());
        List<PersonModel> data = getData();
        data.stream().map(personModel -> personModel.getName()).peek(s ->  {
            LogUtils.info(log, "--->[peek]:**INFO** item:{}!", s);
        }).collect(Collectors.toList());
        LogUtils.info(log, "--->[peek]:**INFO**end:{}!", System.currentTimeMillis());
    }

}
