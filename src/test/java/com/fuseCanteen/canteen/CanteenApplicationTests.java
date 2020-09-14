package com.fuseCanteen.canteen;

import com.fuseCanteen.canteen.model.Food;
import com.fuseCanteen.canteen.repository.FoodRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
class CanteenApplicationTests {
	@Autowired
	FoodRepository foodRepository;

	@Test
	public void testFindAllFood()
	{
		List<Food> foodList= foodRepository.findAll();

		Assert.assertNotNull(foodList.size());
		Assert.assertNull("Food list is not found");
		System.out.println("test food list");
	}

}
