package com.zzmin.demoWebFlux

import com.microsoft.playwright.Browser
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import com.microsoft.playwright.PlaywrightException
import com.zzmin.demoWebFlux.util.Logger


class zzminc {

}
fun scrapNews(){
    Logger.info("=========")
    try {
        Playwright.create().use { playwright ->
            // 1. Browser 객체 생성 _ Headless true (default)
            val browser: Browser = playwright.chromium().launch()

            // 2. BrowserContext 객체에서 Page 생성
            // ** 메모리 내 격리된 브라우저 프로필인 BrowserContext가 존재.
            // ** 서로 간섭하지 않도록 각 테스트마다 새 BrowserContext생성하는 것이 좋음.
            val context = browser.newContext()
            val page: Page = context.newPage()

            // 3. Page 객체 내 기능들
            // (1) 페이지 이동
            page.navigate("https://news.naver.com/section/101")

            // (2) 페이지 타이틀 가져오기
            Logger.info("* title : {}",page.title())//경제 : 네이버 뉴스

            // (3) 페이지내 특정 데이터 읽어오기
            val products = page.querySelectorAll(".ranking_list > .rl_item > .rl_link_end > .rl_content")

            for(i in 0..4){
                val str = products[i].innerText()
                val lines = str.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                if (lines.size == 3) { // 정상
                    Logger.info("${i+1}) => NewsTitle : ${lines[0]} / publisher : ${lines[2]}")
                } else {//에러 - 사이트 바뀜
                    println("ERROR : $str")
                }
            }
            // 4. Page 닫기
            browser.close()
        }
    } catch (e: PlaywrightException) {
        e.printStackTrace()
    }

}