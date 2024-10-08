package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    @RequestMapping({ "/hello-basic", "/hello-hello" })
    public String helloBasic() {

        log.info("helloBasic");
        return "ok";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * 활용 : 리소스 경로에 식별자를 넣는 스타일
     * @PathVariable("userId") String userId -> @PathVariable userId
     * /mapping/userA
     */
    @RequestMapping(value = "/mapping/{userId}")
//    public String mappingPath(@PathVariable("userId") String data) {
//        log.info("mappingPath userId={}"+data);
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId={}"+userId);
        return "ok";
    }

    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long
            orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * Content-Type : 브라우저에서 요청 보낼때 해당 형식으로 보내겠다는 속성
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     * consumes : java에서 받을때 특정형식만 받겠다는 뜻
     *
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * Accept 헤더는 브라우저에서 응답(response) 받을때 특정형식만 받겠다는 속성
     * produces = "text/html"
     * produces = "!text/html" * produces = "text/*"
     * produces = "*\/*"
     * produces : java에서 response 보낼 때 해당 형식으로 보내겠다는 뜻
     * 만약 맞지 않으면 HTTP 406 상태코드(Not Acceptable)을 반환
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }


    /**
     * method 특정 HTTP 메서드 요청만 허용 * GET, HEAD, POST, PUT, PATCH, DELETE
     */
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    /**
     * 편리한 축약 애노테이션 (코드보기)
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

}
