package com.itbarrett.test;


import com.itbarrett.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author : Crazy_Barrett
 * @Date : 2022/05/15 16:44
 * @Description : TODO
 * @Version : V1.0
 */
public class MyBatisTest {
    @Test
    public void test1() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        //获得session对话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行操作 参数：namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");

        //打印数据
        System.out.println(userList);

        //释放资源
        sqlSession.close();

    }
}
