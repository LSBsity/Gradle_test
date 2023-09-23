package org.example;

import com.google.gson.Gson;
import org.apache.commons.collections4.*;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.lang3.*;
import org.apache.commons.math3.linear.*;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String capHello = StringUtils.capitalize("hello");
        String randomStr = RandomStringUtils.randomAlphabetic(10);

        //  첫 문자만 대문자로
        var str1 = "hello world!";
        var str2 = StringUtils.capitalize(str1);

        //  대소문자 무관 포함 여부 확인
        var str1HasHello = StringUtils
                .containsAnyIgnoreCase(str2, "HELLO");

        //  문자열에서 특정 부분 사이의 문자열만 뽑아내기
        var str3 = "이 문장에서 <이것>만 뽑아보세요.";
        var inBrackets = StringUtils
                .substringBetween(str3, "<", ">");

        //  ⭐️ 문자열이 null일 경우 보다 안정적으로 처리
        String str4 = null;
        //var str5 = str4.trim(); // ⚠️ NullPointerException 발생
        var str6 = StringUtils.trim(str4);

        //var str7 = str4.isBlank(); // ⚠️ NullPointerException 발생
        var str8 = StringUtils.isBlank(str4);

        int[] arr1 = {1, 2, 3, 4, 5};

        //  배열에 원소를 추가한 또 다른 배열을 반환
        int[] arr2 = ArrayUtils.add(arr1, 8);

        //  배열에 원소를 제거한 또 다른 배열을 반환
        int[] arr3 = ArrayUtils.removeElement(arr2, 3);

        //  ⚠️ 매 번 새로운 배열 공간 차지 - 자주 사용된다면 리스트로

        ArrayUtils.reverse(arr3);

        //  최대공약수와 최소공배수
        var gcd_12_18 = ArithmeticUtils.gcd(12, 18);
        var lcm_12_18 = ArithmeticUtils.lcm(6, 8);

        //  행렬 연산
        double[][] matrix1 = {{1, 2}, {3, 4}};
        double[][] matrix2 = {{5, 6}, {7, 8}};

        RealMatrix m1 = MatrixUtils.createRealMatrix(matrix1);
        RealMatrix m2 = MatrixUtils.createRealMatrix(matrix2);

        RealMatrix m1Xm2 = m1.multiply(m2);

        //  통계 관련 기능
        double[] values = {1.8, 2.4, 3.7, 4.3, 5.9};
        DescriptiveStatistics stats = new DescriptiveStatistics(values);

        double mean = stats.getMean();
        double sum = stats.getSum();
        double std = stats.getStandardDeviation();
        //  🎓 이 외에도 다양한 수학 관련 고급 기능들 제공

        //  💡 Bag : 중복 포함 가능, 개수 카운트
        Bag<String> bag = new HashBag<>();

        bag.add("아아");
        bag.add("아아");
        bag.add("뜨아");
        bag.add("뜨아", 3); // n개씩 추가 가능

        var iceAmericanos = bag.getCount("아아");
        var hotAmericanos = bag.getCount("뜨아");
        var inMyTimes = bag.getCount("라떼");

        //  💡 MultiMap : key에 여러 value를 가질 수 있음
        MultiMap<String, String> multiMap = new MultiValueMap<>();

        multiMap.put("철수", "개근상");
        multiMap.put("영희", "우수상");
        multiMap.put("영희", "인기상");
        multiMap.put("영희", "모범상");
        multiMap.put("잡돌", "개진상");

        var chulsooAwards = multiMap.get("철수");
        var youngheeAwards = multiMap.get("영희");
        var jabdolAwards = multiMap.get("잡돌");

        //  컬렉션들의 합집합, 차집합, 여집합 등
        List<Character> chrList1 = List.of('A', 'B', 'C', 'D');
        List<Character> chrList2 = List.of('C', 'D', 'E', 'F');

        List<Character> chrUnion = ListUtils.union(chrList1, chrList2);
        List<Character> chrSymmetricDifference = ListUtils.sum(chrList1, chrList2);
        List<Character> chrSubtract = ListUtils.subtract(chrList1, chrList2);
        List<Character> chrIntersection = ListUtils.intersection(chrList1, chrList2);
        List<Character> chrDisjunction = (List<Character>) CollectionUtils.disjunction(chrList1, chrList2);

        Person person1 = new Person(
                "홍길동", 20, 175.5, false,
                "AB", 81.2,
                new Career("ABC Market", 2)
        );

        Gson gson = new Gson();
        String person1Json = gson.toJson(person1);

        String person2Json = "{\"name\":\"홍길동\",\"age\":20,\"height\":175.5,\"married\":false,\"career\":{\"company\":\"ABC Market\",\"years\":2}}";
        Person person2 = gson.fromJson(person2Json, Person.class);
        //transient 필드인 bloodType은 null
    }
}