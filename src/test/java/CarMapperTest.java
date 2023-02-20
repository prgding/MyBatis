import me.ding.pojo.Car;
import me.ding.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class CarMapperTest {
	@Test
	public void testInsert() {
		SqlSession sqlSession = null;
		try {
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
			sqlSession = sqlSessionFactory.openSession();
			int count = sqlSession.insert("insertCar");
			System.out.println(count);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void testUtil() {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		sqlSession.insert("insertCar");
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("carNum", "111");
		map.put("brand", "Porsche");
		map.put("producePrice", 100);
		map.put("produceTime", "2022-02-15");
		map.put("carType", "燃油车");
		SqlSession sqlSession = SqlSessionUtil.openSession();
		sqlSession.insert("insertCar", map);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testPojo(){
		Car car = new Car("111", "Porsche", 100.0, "2022-02-15", "燃油车");
		SqlSession sqlSession = SqlSessionUtil.openSession();
		sqlSession.insert("insertPojo", car);
		sqlSession.commit();
		sqlSession.close();
	}
}
