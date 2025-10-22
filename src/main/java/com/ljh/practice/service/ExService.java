package com.ljh.practice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class ExService {

    private static final Logger log = LoggerFactory.getLogger(ExService.class);

    public String sayHello(String hi) {
        String msg = hi + " 좋은날";
        System.out.println(msg);
        log.info(msg);
        log.warn(msg);
        log.debug(msg);
        return msg;
    }

    public String ex321() {
        int number = 1;
        String result = "";

        if (number == 1) {
            result = "if 블록입니다.";
            log.info(result);
        } else if (number == 2) {
            result = "else if 블록입니다.";
            log.info(result);
        } else {
            result = "else 블록입니다.";
            log.info(result);
        }

        return result;
    }

    public Integer exInt() {
        return 999;
    }

    public String ex322() {
        String result = "";
        int[] array = {1, 2, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            result += " i = " + array[i];
            log.info(result);
        }
        return result;
    }

    public String ex323() {
        String result = "";
        int[] array = {1, 2, 3, 4, 5};
        int i = 0;

        while (i < array.length) {
            result += " i = " + array[i];
            log.info(result);
            i++;
        }
        return result;
    }

    public interface Car {
        public String getColor();
    }

    public class Sonata implements Car {
        public Sonata() {
            log.info("=== 출고 === Sonata");
        }

        @Override
        public String getColor() {
            return "=== 색상: RED === Sonata";
        }

    }

    public class K5 implements Car {
        public K5() {
            log.info("=== 출고 === K5");
        }

        @Override
        public String getColor() {
            return "=== 색상: YELLOW === K5";
        }

    }

    public String ex324() {
        Car car1 = new Sonata();
        String re1 = car1.getColor();
        Car car2 = new K5();
        String re2 = car2.getColor();

        String result = re1 + "<br>" + re2 + "<br>" + "차 두대를 출고하였음.";
        return result;
    }


    public String ex325() {
        String result = "";

        List list = new ArrayList<Integer>();
        log.info(result);
        list.add(1);
        list.add(2);
        list.add(3);

        result = list.get(1).toString();

        return result;
    }


    public String ex326() {
        List<String> list = new ArrayList<>();

        list.add("public");
        list.add("static");
        list.add("void");
        String result = "";

        for (int i = 0; i < list.size(); i++) {
            result += (list.get(i));
        }

        log.info(result);

        list.remove(1);
        int voidIndex = list.indexOf("void");

        return result;
    }

    public String ex327() {
        String str1 = new String("is same?");
        String str2 = new String("is same?");

        boolean isSameByRef = (str1 == str2);
        String result = "result : " + isSameByRef;

        log.info(result);
        return result;
    }

    public String ex328() {
        String str1 = new String("is same?");
        String str2 = new String("is same?");

        boolean isSameByVal = str1.equals(str2);
        String result = "result : " + isSameByVal;

        log.info(result);
        return result;

    }

    public String ex331() {
        List<String> list = new ArrayList<>();

        list.add("public");
        list.add("static");
        list.add("void");

        list.sort(String::compareTo);

        String result = String.join(",", list);
        log.info("sorted = {}", result);

        return result;
    }


    public String ex332() {
        List list = new ArrayList<String>();

        list.add("public");
        list.add("static");
        list.add("void");

        String result = String.join(",", list);

        list.stream().forEach(str -> log.info("token={}", str));

        return result;
    }

    public String ex333() {
        Integer[] integerArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = Arrays.asList(integerArray);

        List evenList = new ArrayList<Integer>();


        for (int i = 0; i < list.size(); i++) {
            Integer number = list.get(i);
            if (number % 2 == 0) {
                evenList.add(number);
            }
        }
        for (int i = 0; i < evenList.size(); i++) {
            log.info("even[{}] = {}", i, evenList.get(i));
        }

        String result = evenList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")).toString();

        return result;
    }

    public String ex334() {
        Integer[] integerArray = new Integer[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        List<Integer> list = Arrays.asList(integerArray);

        List<Integer> evenList = list.stream()
                .filter(value -> value % 2 == 0)
                .collect(Collectors.toList());

        String result = evenList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        log.info("evenList= {}", result);

        return result;
    }

    // http://localhost:8090/ex335
    public String ex335() {
        Integer[] integerArray = new Integer[]{1, 5, 6, 9, 8, 10, 15, 48, 156, 789};

        List<Integer> list = Arrays.asList(integerArray);

        list.stream().forEach(value -> log.info("{}", value));

        String result = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        log.info("result(list joined) = {}", result);

        return result;
    }

    public String ex336() {
        Integer[] integerArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = Arrays.asList(integerArray);

        List evenList = list.stream().
                filter(value -> value % 2 == 0).
                toList();
        evenList.forEach(value -> log.info("짝수 = {}", value));

        String result = evenList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")).toString();

        return result;
    }

    public String ex337() {
        Integer[] integerArray = new Integer[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        List<Integer> list = Arrays.asList(integerArray);

        List<Integer> distinctList = list.stream().distinct().toList();

        distinctList.forEach(value -> log.info
                ("순서 유지하며 중복 제거 = {}", value));

        String result = distinctList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        return result;
    }

    public String ex338() {
        List<String> uppercaseList = Arrays.asList("public", "static", "void").stream()
                .map(String::toUpperCase)
                .toList();
        uppercaseList.forEach(v -> log.info("{}", v));
        return String.join("<br>", uppercaseList);
    }

    public String ex339() {
        String src = this.getSomeString();
        String result = (src == null) ? "EMPTY" : src.toUpperCase();
        log.info("ex339 result = {}", result);
        return result;
    }

    private String getSomeString() {
        return null;
    }

    public String ex3310() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 10, 8, 9));
        list.sort(Comparator.reverseOrder());
        String result = list.stream().map(String::valueOf).
                collect(Collectors.joining(","));
        log.info("desc = {}", result);
        return result;
    }
}
