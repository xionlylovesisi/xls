package com.xlm.stream.data;

import lombok.*;
import lombok.Data;

/**
 * @author xls
 * @date 2019-04-16
 * @description
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PersonModel implements Comparable<PersonModel>{
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别
     */
    private String sex;

    @Override
    public int compareTo(PersonModel o) {
        if(this.age > o.getAge()){
            return 1;
        }else if (this.equals(o)){
            return 0;
        }else{
            return -1;
        }
    }
}
