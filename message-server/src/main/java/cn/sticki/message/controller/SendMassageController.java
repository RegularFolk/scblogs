package cn.sticki.message.controller;

import cn.sticki.common.pojo.MailDTO;
import cn.sticki.common.pojo.RestResult;
import cn.sticki.message.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/send")
public class SendMassageController {

	@Resource
	private MailService mailService;

	@PostMapping("/mail")
	public RestResult<Object> sendMail(MailDTO mail) {
		try {
			mailService.sendMail(mail);
			return new RestResult<>(true, "发送成功");
		} catch (Exception e) {
			return new RestResult<>(false, "发送失败");
		}
	}

}
