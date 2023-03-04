import me.ding.pojo.Car;
import me.ding.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CarMapperTest {
	@Test
	public void testOriginalInsert() {
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
	public void testUtilInsert() {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		sqlSession.insert("insertCar");
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testMapInsert() {
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
	public void testPojoInsert() {
		Car car = new Car(22L, "123", "Porsche", 100.3, "2022-02-20", "燃油车");
		SqlSession sqlSession = SqlSessionUtil.openSession();
		int insert = sqlSession.insert("insertPojo", car);
		System.out.println(insert);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void deleteById() {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		sqlSession.delete("deleteById", 24);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void updateById() {
		SqlSession sqlSession = SqlSessionUtil.openSession();
		Car car = new Car(22L, "123", "Porsche", 100.3, "2022-02-20", "燃油车");
		sqlSession.update("updateById", car);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void selectById(){
		SqlSession sqlSession = SqlSessionUtil.openSession();
		Object car = sqlSession.selectOne("selectById", 22);
		System.out.println(car);
		sqlSession.close();
	}

	@Test
	public void selectAll(){
		SqlSession sqlSession = SqlSessionUtil.openSession();
		List<Object> cars = sqlSession.selectList("selectAll");
		cars.forEach(System.out::println);

		sqlSession.close();
	}
}