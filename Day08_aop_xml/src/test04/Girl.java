package test04;

import java.util.Random;

public class Girl implements Person {
	public String doSomething(int n) throws Exception {
		//// 핵심 관심사항 (수행 도중 예외 발생할 수 있음)
		System.out.println("순대국을 만든다." + n + "인분");
		if (new Random().nextBoolean()) {
			System.out.println("불이 났다!!!");
			throw new Exception("불났어!!");
		}
		return "순대국 맛있네";
	}
}
