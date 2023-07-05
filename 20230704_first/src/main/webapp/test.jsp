<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카페 포스기</title>
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link href="/resources/css/reset.css" rel="stylesheet">
    <!-- <link rel="stylesheet" href="/resources/css/reset.css"> -->
    <!-- style 지정 - 각자 실습 -->
    <!-- -->
    <script>
        $(loadedHandler);
        function loadedHandler(){
            // event 등록
            //$('.c').on("blur", cntBlurHandler);
            $("[type=button]").on("click", calClickHandler);
        }
        // 각종 기능 함수들
        function cntBlurHandler(e){
            // console.log(this);
            // console.log(e.target); // event.target == this
            // console.log(e);
            // 각자 실습
            // console.log($(this).parent().prev().html());
            // console.log($(this).parent().prev().text());
            console.log($(this).val()); // console.log(this.value);
            // 메뉴마다 합계가격
            $(this).parent().next().children('input.p').val(
                $(this).parent().prev().text()
                *
                $(this).val()
            );
            updateTotal();
            // var price = $(this).parent().prev().text() * $(this).val();
            // var sum = 0;
            // // 메뉴 총 개수 합계
            // // each - for문은 대신함. event에 handler 를 등록함
            // // each function 에서의 this사용시 위 this와 헷갈림.
            // // $(".c").each(cTotalCntHandler);
            // // $(".c").each(function(idx){
            // //     //console.log(price);
            // //     // item = this
            // //     console.log(this);
            // //     // console.log(typeof($(this).val()));
            // //     sum += Number($(this).val());
            // // });
            // // $(".c").each(function(idx, item){
            // $(".c.in").each(function(idx, item){
            //     //console.log(price);
            //     // item = this
            //     console.log(item);
            //     // console.log(typeof($(this).val()));
            //     // if(idx != $(".c").length-1){
            //         var i = Number($(item).val());
            //         if(isNaN(i)){
            //             i = 0;
            //         }
            //         // sum += Number($(item).val());
            //         sum += i;
            //     // }
            // });
            // console.log(sum);
            // $("#cTotalCnt").val(sum);

            // sum = 0;
            // // 합계
            // $(".p").each(function(idx, item){
            //     console.log(item);
            //     if(idx != $(".p").length-1){
            //         // Number() 대신 *1로 숫자형태변경
            //         var i = $(item).val() * 1;
            //         if(isNaN(i)){
            //             i = 0;
            //         }
            //         sum += i;
            //     }
            // });
            // console.log(sum);
            // $("#cTotalPrice").val(sum);
            // // $("#cTotalCnt").val(globalValueSum);
            // // $("#cTotalCnt").val(sum);
            // // $("#cTotalPrice").val(sum);
        }

        function calClickHandler(e){
            // console.log(this);
            // console.log(e.target); // event.target == this
            // console.log(e);
            // 각자 실습
            $(".c.in").each(function(idx, item){
                //this = item
                console.log(this);
                // 메뉴마다 합계가격
                $(this).parent().next().children('input.p').val(
                    $(this).parent().prev().text()
                    *
                    $(this).val()
                );
                // $(item).parent().next().children('input.p').val(
                //     $(item).parent().prev().text()
                //     *
                //     $(item).val()
                // );
            });
            updateTotal();
        }
        function updateTotal(){
            var sum = 0;
            // 메뉴 총 개수 합계
            $(".c.in").each(function(idx, item){
                // each - for문은 대신함. event에 handler 를 등록함
                // each function 에서의 this사용시 위 this와 헷갈림.
                //console.log(price);
                // item = this
                console.log(item);
                //if(idx != $(".p").length-1){
                    var i = Number($(item).val());
                    if(isNaN(i)){
                        i = 0;
                    }
                    sum += i;
                //}
            });
            console.log(sum);
            $("#cTotalCnt").val(sum);

            sum = 0;
            // 합계
            $(".p").each(function(idx, item){
                console.log(item);
                if(idx != $(".p").length-1){
                    // Number() 대신 *1로 숫자형태변경
                    var i = $(item).val() * 1;
                    if(isNaN(i)){
                        i = 0;
                    }
                    sum += i;
                }
            });
            console.log(sum);
            $("#cTotalPrice").val(sum);
        }
        // each경우 event handler 처럼 함수형태 만들어서 사용하지 않음 - 권장
        // var globalValueSum = 0;
        // function cTotalCntHandler(idx){
        //     // console.log(price);
        //     // item = this
        //     console.log(this);
        //     // sum += $(this).val();
        //     globalValueSum += $(this).val();
        // };
    </script>
</head>
<body>
<!-- 여기가 보임 -->
당신이 요청한 n1의 값 <%= request.getParameter("n1") %> 응답은 아래와 같습니다.
    <form>
        <table border="1">
            <tr>
                <th>메뉴</th>
                <th>가격</th>
                <th>수량</th>
                <th>합계</th>
            </tr>
            <tr>
                <td>아메리카노</td>
                <td>2500</td>
                <!-- <td><input type="text" name="c1" id="c1" class="c"></td> -->
                <!-- <td><input type="text" name="c1Price" id="c1Price" class="p" readonly></td> -->
                <td><input type="text" name="c1" class="c in"></td>
                <td><input type="text" name="c1Price" class="p" readonly></td>
            </tr>
            <tr>
                <td>라떼</td>
                <td>3000</td>
                <!-- <td><input type="text" name="c2" id="c2" class="c"></td> -->
                <!-- <td><input type="text" name="c2Price" id="c2Price" class="p" readonly></td> -->
                <td><input type="text" name="c2" class="c in"></td>
                <td><input type="text" name="c2Price" class="p" readonly></td>
            </tr>
            <tr>
                <td>생강라떼</td>
                <td>4500</td>
                <!-- <td><input type="text" name="c3" id="c3" class="c"></td> -->
                <!-- <td><input type="text" name="c3Price" id="c3Price" class="p" readonly></td> -->
                <td><input type="text" name="c3" class="c in"></td>
                <td><input type="text" name="c3Price" class="p" readonly></td>
            </tr>
            <tr>
                <td>딸기바나나라떼</td>
                <td>4500</td>
                <!-- <td><input type="text" name="c4" id="c4" class="c"></td> -->
                <!-- <td><input type="text" name="c4Price" id="c4Price" class="p" readonly></td> -->
                <td><input type="text" name="c4" class="c in"></td>
                <td><input type="text" name="c4Price" class="p" readonly></td>
            </tr>
            <tr>
                <th>합계</th>
                <th></th>
                <th><input type="text" name="cTotalCnt" id="cTotalCnt" class="c" readonly></th>
                <th><input type="text" name="cTotalPrice" id="cTotalPrice" class="p" readonly></th>
            </tr>
            <tr>
                <td colspan="4">
                    <input type="button" value="계산하기">
                    <input type="reset">
                </td>
            </tr>
        </table>
    
    </form>
</body>
</html>