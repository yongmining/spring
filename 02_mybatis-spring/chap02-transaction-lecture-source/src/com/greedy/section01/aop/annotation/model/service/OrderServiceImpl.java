package com.greedy.section01.aop.annotation.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.section01.aop.annotation.model.dao.OrderMapper;
import com.greedy.section01.aop.annotation.model.dto.OrderDTO;
import com.greedy.section01.aop.annotation.model.dto.OrderMenuDTO;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	private final OrderMapper orderMapper;
	
	@Autowired
	public OrderServiceImpl(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}
	
	/* 전파 행위 옵션(Propagation) : 트랜젝션 범위 설정
	 * REQUIRED : 진행중인 트랜젝션이 있으면 현재 메소드를 그 트랜젝션에서 실행하되 그렇지 않으면 새 트랜젝션을 시작한다.
	 * REQUIRED_NEW : 항상 새 트랜젝션을 시작해 그 메소드를 실행하고 진행중인 트랜젝션이 있으면 잠시 중단한다.
	 * SUPPORTS : 진행중인 트랜젝션이 있으면 현재 메소드를 그 트랜젝션 내에서 실행하고, 그렇지 않을 경우 트랜젝션 없이 실행한다.
	 * NOT_SUPPORTED : 트랜젝션 없이 현재 메소드를 실행하되, 진행중인 트랜젝션이 있으면 잠시 중단한다.
	 * MANADATORY : 반드시 트랜젝션을 걸고 현재 메소드를 실행하되 진행중인 트랜젝션이 있으면 예외를 던진다.
	 * NEVER : 반드시 트랜젝션 없이 현재 메소드를 실행하되 진행중인 트랜젝션이 있으면 예외를 던진다.
	 * NESTED : 진행중인 트랜젝션이 있으면 현재 메소드를 이 트랜젝션의 중첩 트랜젝션 내에서 실행한다.
	 *          트랜젝션이 없으면 새 트랜젝션을 실행한다.
	 *          배치 실행 도중 처리할 업무가 백만개라고 하면 10만개씩 끊어서 커밋하는 경우 중간에 잘못 되어도
	 *          중첩 트랜젝션을 롤백하면 전체가 아닌 10만개만 롤백된다. (세이브포인트 이용)
	 *          세이브포인트를 지원하지 않는 DBMS에서는 사용이 불가능하다.
	 *          
	 * 격리 레벨(Isolation) : 동시성 고려
	 * DEFAULT : DB의 기본 격리 수준을 사용한다. 대다수는 read commited가 기본 격리 수준이다.
	 * READ_UNCOMMITED : 다른 트랜젝션이 아직 커밋하지 않은 값을 한 트랜젝션이 읽을 수 있다.
	 * 				     따라서 오염된 값을 읽거나, 재현 불가능한 읽기, 허상읽기 등의 문제가 발생할 수 있다.
	 * READ_COMMITED : 트랜젝션이 다른 트랜젝션에서 커밋한 값만 읽을 수 있다.
	 * 				   오염된 값 읽기 문제는 해결되지만, 재현 불가능한 읽기, 허상읽기 등의 문제는 여전히 남아있다.
	 * REPEATABLE_READ : 트랜젝션이 어떤 필드를 여러 번 읽어도 동일한 값을 읽도록 보장한다,
	 * 					 트랜젝션이 지속되는 동안에는 다른 트랜젝션이 해당 필드를 변경할 수 없다.
	 * SERIALIZABLE : 트랜젝션이 테이블을 여러 번 읽어도 정확한 동일한 로우를 읽도록 보장한다.
	 * 				  트랜젝션이 지속되는 동안 다른 트랜젝션이 해당 테이블에 삽입, 수정, 삭제를 할 수 없다.
	 * 				  동시성 문제는 모두 해소되지만 성능은 현저하게 떨어진다.
	 * 
	 * 오염된 값 : 하나의 트랜젝션이 데이터를 변경 후 잠시 기다리는 동안 다른 트랜젝션이 데이터를 읽게 되면,
	 * 			 격리 레벨이 READ_UNCOMMITED인 경우 아직 변경 후 커밋되지 않은 재고값을 그대로 읽게 된다.
	 * 			 그러나 처음 트랜젝션이 데이터를 롤백하게 되면 다른 트랜젝션이 읽은 값은 더 이상 유효하지 않는
	 * 			 일시적인 값이 되고, 이것을 오염된 값이라고 한다.
	 * 재현 불가능한 읽기 : 처음 트랜젝션이 데이터를 수정하면 수정이 되고, 아직 커밋되지 않은 로우에 수정잠금을 걸어둔 상태이다.
	 * 				    결국 다른 트랜젝션은 이 트랜젝션이 컴밋 혹은 롤백 되고 수정잠금이 풀릴 때 까지 기다렸다가
	 * 					읽을 수 밖에 없게 된다.
	 * 					하지만 다른 로우에 대해서는 또 다른 트랜젝션이 데이터를 수정하고 커밋하게 되면
	 * 					가장 처음 동작한 트랜젝션이 데이터를 커밋하고, 다시 조회를 한 경우 처음 읽은 값이 아니게 된다.
	 * 					이것이 재현 불가능한 읽기이다.
	 * 허상읽기 : 처음 트랜젝션이 테이블에서 여러 로우를 읽은 후 이후 트랜젝션이 같은 테이블의 로우를 추가하는 경우
	 * 			차음 트랜젝션이 같은 테이블을 다시 읽으면 자신 처음 읽었을 때와 달리 새로 추가된 로우가 있을 것이다.
	 * 			이것을 허상읽기라고 한다.  (재현불가능한 읽기와 비슷하지만 허상읽기는 로우가 추가되는 경우를 말한다.)
	 * 
	 * mysql은 기본 격리 수준이 repeatable read이고 오라클은 read commited 이다.
	 * */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
			rollbackFor = {RuntimeException.class})
	public void registOrder(OrderDTO order) {
	
		orderMapper.insertOrder(order);
		
		List<OrderMenuDTO> orderMenuList = order.getMenuList();
		for(OrderMenuDTO orderMenu : orderMenuList) {
			orderMapper.insertOrderMenu(orderMenu);
		}
	
	}
}
