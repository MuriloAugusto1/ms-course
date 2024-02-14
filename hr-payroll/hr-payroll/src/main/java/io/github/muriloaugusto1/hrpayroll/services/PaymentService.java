package io.github.muriloaugusto1.hrpayroll.services;

import io.github.muriloaugusto1.hrpayroll.entities.Payment;
import io.github.muriloaugusto1.hrpayroll.entities.Worker;
import io.github.muriloaugusto1.hrpayroll.feignClients.WorkerFeignClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(long workerId, int days) {

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
