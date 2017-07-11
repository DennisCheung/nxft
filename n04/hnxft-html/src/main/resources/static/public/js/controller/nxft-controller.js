/**
 * Created by yw on 2017/5/18.
 */
'use strict';
angular.module('app')
    .run(['$http',function ($http) {
    }])
    /*--------------- 登录页 ----------------*/
    .controller('loginCtrl', ['$scope', '$http',"$cookies","$state",function ($scope, $http,$cookies,$state) {
        //记住图片
        if($cookies.get("managePass")){
            $scope.phNumber=$cookies.get("managePass");
            $scope.imgurl="../images/true.png";
            $scope.flag=true;
        }else{
            $scope.imgurl="../images/false.png";
            $scope.flag=false;
        }
        //密码提示文字
        $scope.showButton = false;
        $scope.sure=function(){
            if($scope.phNumber){
                $http.get("../../app/verificationUser",{
                    params:{
                        password:$scope.phNumber
                    }
                }).then(function(response){
                    if(response.data){
                        $scope.alText="登录成功";
                        if($scope.flag){
                            $cookies.put("managePass",$scope.phNumber);
                        }
                        $state.go("manageFeature");
                    }else{
                        $scope.alText="输入错误，请校正登录！";
                    }

                }).catch(function(error){
                    console.log(error);
                });
            }else{
                $scope.showButton=true;
            }
        }
        /*记住密码的默认图片地址*/
        $scope.remember=function(){
            if($scope.flag==false){
                $scope.imgurl="../images/true.png";
                $scope.flag=true;
            }else{
                $scope.imgurl="../images/false.png";
                $scope.flag=false;
                $cookies.remove("managePass");
            }
        }
    }])
    /*--------------- 登录选择AB页 ----------------*/
    .controller('loginABCtrl', ['$scope', '$http',"$cookies","$state",function ($scope, $http,$cookies,$state) {
        $http({
            method: 'GET',
            url: '../../app/queryCircleAndTeam'
        }).then(function (response) {
            // 请求成功执行代码
            $scope.data=response.data.list;
        }, function (error) {
            // 请求失败执行代码
            console.log("失败");
        });
        $scope.save=function(item){
            localStorage.setItem("list",JSON.stringify(item.teamList));
            $cookies.put('company',item.circleModel.circleShortName);
            $state.go("loginZcd");
        }
    }])
    /*--------------- 暖心饭堂登录助餐点页 ----------------*/
    .controller('loginZcdCtrl', ['$scope', '$http',"$cookies","$stateParams","$state",function ($scope, $http,$cookies,$stateParams,$state) {
         $scope.data=JSON.parse(localStorage.getItem("list"));
        $scope.save=function(item){
            $cookies.put("circleId",item.circleId);
            $cookies.put("teamId",item.id);
            $cookies.put("teamName",item.teamName);
            $state.go("gaikuang");
        }
    }])
    /*--------------- 管理员点餐或自助点餐----------------*/
    .controller('useListCtrl', ['$scope', '$http',"$cookies","$state",function ($scope, $http,$cookies,$state) {
        $scope.teamName=$cookies.get("teamName");
        $scope.self_service=false;
        /*自助点餐输入手机号按确定*/
        $scope.phNumber="";
        $scope.self=function(){
            if($scope.phNumber){
                $http.get("../../app/findSubjectByMobile",{
                    params:{
                        teamId:$cookies.get("teamId"),
                        mobile:$scope.phNumber
                    }
                }).then(function(response){
                    if(Boolean(response.data)==false){
                        $scope.self_alert="没有这个用户！";
                    }else{
                        $scope.self_alert="登录成功";
                        if(response.status==200){
                            $cookies.put("personInfo",JSON.stringify(response.data));
                            $cookies.put("personId",response.data.personInfo.personId);
                            $state.go("order2",{"active":'useList'});
                        }
                    }
                    $scope.item=response.data;
                }).catch(function(error){
                    $scope.self_alert="输入错误，请校正登录！";
                });
            }else{
                $scope.self_alert="请输入手机全位号/固话，再登录！";
            }
        }
    }])
    /*--------------- 用户列表----------------*/
    .controller('useDetailCtrl', ['$scope', '$http',"$cookies","$state",function ($scope, $http,$cookies,$state) {
       //查询名单列表
        $http.get("../../app/findAllSubejct",{
            params:{
                teamId:$cookies.get("teamId")
            }
        }).then(function(response){
            $scope.list=response.data;
        }).catch(function(error){
            console.log(error);
        });
        //点击确定保存当前数据
        $scope.save=function(item){
            $cookies.put("personInfo",JSON.stringify(item));
            $cookies.put("personId",item.personInfo.personId);
            $state.go("order2",{active:'useDetail'});
        }
        //退出回话
        $scope.Quit=function(){
            //移除回话
            $http.get("../../app/orderAntiVerification").then(function(response){
                window.history.go(-1);
            }).catch(function(error){
                console.log(error);
            });
        }
    }])
    /*--------------- 暖心饭堂概况助餐点数据墙 ----------------*/
    .controller('gaikuangCtrl', ['$scope', '$http',"$cookies","$state","$stateParams",function ($scope, $http,$cookies,$state,$stateParams){
        $scope.teamName=$cookies.get("teamName");
        /*右边切换运营商*/
        $scope.company=$cookies.get("company");
        $scope.mask_password=false;
        $scope.manage=function(){
            if($scope.manage_password){
                $http.get("../../app/orderVerificationUser",{params:{password:$scope.manage_password}}).then(function(response){
                    if(response.data){
                        $scope.manage_alert="登录成功！";
                        $state.go("loginAB");
                    }else{
                        $scope.manage_alert="密码错误，请校正登录！";
                    }
                }).catch(function(error){
                    console.log(error);
                });
            }else{
                $scope.manage_alert="请输入密码，再登录！";
            }
        }
        $("#quxiao").click(function(){
            $("#mask").css("display","none");
        });
        $scope.queding=function(){
            if($("#input").val()){
                $http.get("../../app/verificationUser",{params:{
                    password:$("#input").val()
                }}).then(function(response){
                    if(response.data){
                        $state.go($scope.flag);
                    }else{
                        $("#false-alert").html("密码错误，请校正登录！");
                        $("#false-alert").css("visibility","visible");
                    }
                }).catch(function(error){
                    console.log("失败");
                });
            }else{
                $("#false-alert").html("请输入密码，再登录！");
                $("#false-alert").css("visibility","visible");
            }
        }
        $scope.myFunc=function(){
            $state.go("loginZcd");
        }
        /*菜谱*/
        $("#next").click(function(){
            $("#picList").stop().animate({left:"-4.95rem"},2000,function(){
            });
        });
        $("#prev").click(function(){
            $("#picList").stop().animate({left:"0px"},2000,function(){
            });
        });
        var time=getDate();
        $scope.prevDate=getChangeDate(time,"monday");
        $scope.nextDate=getChangeDate(time,"sunday");
        $scope.prevWeek=function(){
            time=getDate(time,"prev");
            $scope.prevDate=getChangeDate(time,"monday");
            $scope.nextDate=getChangeDate(time,"sunday");
            /*菜谱*/
            $http.get("../../app/findScheData",{
                params:{
                    teamId:$cookies.get("teamId"),
                    weekDateBegin:time
                }
            }).then(function(response){
                $scope.list=response.data;
            }).catch(function(error){
                console.log(error);
            });
        }
        $scope.nextWeek=function(){
            time=getDate(time,"next");
            $scope.prevDate=getChangeDate(time,"monday");
            $scope.nextDate=getChangeDate(time,"sunday");
            /*菜谱*/
            $http.get("../../app/findScheData",{
                params:{
                    teamId:$cookies.get("teamId"),
                    weekDateBegin:time
                }
            }).then(function(response){
                $scope.list=response.data;
            }).catch(function(error){
                console.log(error);
            });
        }
        /*菜谱*/
        $http.get("../../app/findScheData",{
            params:{
                teamId:$cookies.get("teamId"),
                weekDateBegin:time
            }
        }).then(function(response){
            $scope.list=response.data;
        }).catch(function(error){
            console.log(error);
        });
        function getDate(d,s) {
            var date = new Date();
            if(d){
                date = new Date(d);
                if(s=="next"){
                    date = new Date(d);
                    date = +date + 1000*60*60*24*7;
                    date = new Date(date);
                }else if(s=="prev"){
                    date = new Date(d);
                    date = +date - 1000*60*60*24*7;
                    date = new Date(date);
                }
            }
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if(month >= 1 && month <= 9) {
                month ="0" + month;
            }
            if(strDate >= 0 && strDate <= 9) {
                strDate ="0" + strDate;
            }
            var currentdate = date.getFullYear() + "-" + month + "-" + strDate;
            return currentdate;
        }
        function getChangeDate(d,c){//d:日期字符串,c
            var now=new Date(d);
            var t=now.getDay();
            var monday,sunday;
            if(t==0){
                monday=+now-6*24*60*60*1000;
                sunday=now;
            }else if(t==1){
                monday=now;
                sunday=+now+6*24*60*60*1000;
            }else if(t==2){
                monday=+now-24*60*60*1000;
                sunday=+now+5*24*60*60*1000;
            }else if(t==3){
                monday=+now-2*24*60*60*1000;
                sunday=+now+4*24*60*60*1000;
            }else if(t==4){
                monday=+now-3*24*60*60*1000;
                sunday=+now+3*24*60*60*1000;
            }else if(t==5){
                monday=+now-4*24*60*60*1000;
                sunday=+now+2*24*60*60*1000;
            }else if(t==6){
                monday=+now-5*24*60*60*1000;
                sunday=+now+24*60*60*1000;
            }
            if(c=="monday"){
                return getDate(monday);
            }else if(c=="sunday"){
                return getDate(sunday);
            }
        }
    }])
    /*--------------- 概况-咨询-内容页 ----------------*/
    .controller('gaikuangNewsArticleCtrl', ['$scope',"$stateParams","$cookies",function ($scope,$stateParams,$cookies) {
        $scope.teamName=$cookies.get("teamName");
        var num=Number($stateParams.did);
        switch (num) {
            case 1:
                $scope.title="雅居乐健康之家开展第四期健康讲座";
                $scope.time="2017-04-26";
                $scope.author="";
                $scope.pictures=["../images/ncontent/pic111.png"];
                $scope.plist=["2017年4月26日，雅居乐健康之家开展第四期健康讲座，主题为《老年人心理健康》，由福通智联家庭服务中心健康管家邱医生主讲，邀请员岗社区的医护人员参与，现场有28位居民前来听课。",
                    "讲座前，员岗社区医护人员在健康之家门口设点为居民测量血糖，然后为他们送上了早餐，接着，由福通智联工作人员引领他们就坐及派发讲座内容介绍，期间为他们测量血压。到了9:40，讲座正式开始，邱医生为大家详细讲解了健康的定义、心理健康的五个原则、老年人的五种心理变化、长寿老人的六大心理特征、老年人不良情绪的疏导等内容，在场居民认真听课，积极向医生提问，诉说自己的心事，医生耐心倾听并给出安慰和建议。",
                    "本次健康讲座向居民传播了心理健康保健知识，解答了老人的疑问，进行了适当的心理疏导，从而有助于提高他们的生活质量，得到居民的热烈反响。"
                ];
                break;
            case 2:
                $scope.title="雅居乐健康之家开展第三期健康讲座";
                $scope.time="2017-03-23";
                $scope.author="";
                $scope.pictures=["../images/ncontent/1.png"];
                $scope.plist=["2017年3月23日，雅居乐健康之家开展第三期健康讲座，主题为《中医体 质辨识》，由福通智联家庭服务中心方医生主讲，有19名居民到场听课 。",
                    "讲座上，方医生介绍了九种中医体质中的四种（气虚体质、阳虚体质、 阴虚体质和血瘀体质），分别从体质的发展因素、具体表现及调理三个 方面进行详细讲解，居民认真听课，根据所讲的内容判断自己属于哪种 体质，并提出问题，方医生耐心进行解答。居民学习热情高涨，直到课 堂结束，居民仍不愿离开。",
                    "健康之家作为传播健康知识的重要窗口，由专业医护人员亲自传授实用 知识，增强他们的健康意识，从而有效地提高他们的晚年生活质量，得 到居民的热烈反响。（文/戴静）"
                ];
                break;
            case 3:
                $scope.title="雅居乐健康之家举行健康讲座";
                $scope.time="2017-02-23";
                $scope.author="";
                $scope.pictures=[""];
                $scope.plist=["2017年2月23日，福通智联家庭服务中心联合雅居乐居委会在雅居乐社区健康之家举行《节后轻松消食》健康讲座，19位居民前来参加。",
                    "早上9:00，居民们陆续到场，工作人员为他们测量血压，送上泡好的金银菊花茶。9:30讲座正式开始，首先由主持人小眉介绍参与活动的工作人员，然后福通智联的林医生详细介绍有关助消化的水果、蔬菜、茶类等，以及讲解穴位保健知识，并现场作示范，亲自指导每一位居民如何寻找穴位，大家认真学习，现场学习气氛良好。有居民反应希望可以加强健康之家的宣传工作，多举行类似健康讲座这样有意义的活动。",
                    "本次健康讲座成功举行，收到预期的效果，让居民真切学习到健康知识，同时加强对健康之家的宣传作用。"
                ];
                break;
            case 4:
                $scope.title="福通智联联合雅居乐居委会举行“送猴迎金鸡”趣味活动";
                $scope.time="2017-01-13";
                $scope.author="";
                $scope.pictures=[""];
                $scope.plist=["2017年1月13日,福通智联家庭服务中心联合雅居乐居委会在雅居乐社区健康之家举行了“送猴迎金鸡”趣味活动，有45位居民前来参加。",
                    "早上，居民冒着寒风细雨陆续到场，两位阿姨高歌一曲作为活动热身。9：40活动正式开始，首先由潘护士给大家介绍了有关春节饮食的内容，讲解了高血压、高血脂、糖尿病等饮食注意事项，消化不良、肠梗阻等处理方法，以及介绍了如何选购节日食品等。居民认真听讲，受益匪浅。随后进入游戏环节，居民来到游戏专区，工作人员为他们准备了“健康棒棒过大年”、“快乐幸福互传递”、“欢乐猜一猜”、“套福运”、“双龙戏珠”等多种有趣的游戏，还有抽奖活动。居民们积极参加，最后每个人都拿到奖品，现场充满欢声笑语，提前感受到节日的气氛。",
                    "本次活动成功举行，收到预期的效果，既能让居民提前感受到春节的欢乐，增进邻里感情，也能学习到有关的健康知识，同时为健康之家起到一定的宣传作用。"
                ];
                break;
            case 5:
                $scope.title="为走失老人配上智能黄手环";
                $scope.time="2017-04-14";
                $scope.author="";
                $scope.pictures=[""];
                $scope.plist=["家住市桥街富都社区的卢大叔今年72岁，患有高血压、老人痴呆。4月5日下午，他独自一人外出，家人发现他不见后十分担心，通过微信朋友圈转发等方式，最终于4月6日在化龙医院找到他。这次幸好有热心路人看到大叔晕倒在地上，把他送到附近的医院，医生根据他身上的名片通知家人带他回家。",
                    "福通智联家庭服务中心有关领导得知此事件后，通过微信转发的消息与大叔家属取得联系，随后与市桥街民政部门商量为他配备一个智能黄手环。4月14日下午，福通智联工作人员与市桥街富都社区民政干部一同前往大叔家，为他送上手环，并详细介绍手环的作用及操作方法，家属非常感谢居委领导及工作人员的关心与帮助，表示以后再也不用过于担心大叔走失的问题。",
                    "智能黄手环关爱行动在番禺区开展，现沙湾、南村、沙头等多个镇街符合条件的老人已收到手环并正在使用。通过互联网技术，手环可实现“一键SOS呼叫”、“二维码名片识别”、“走出围栏提醒”等功能，使家人可随时远程了解老人行动轨迹，体现出互联网+联动型医养结合居家养老服务的便利。"
                ];
                break;
            case 6:
                $scope.title="板桥村委联同福通智联家庭服务中心举办健康讲座";
                $scope.time="2016-10-20";
                $scope.author="";
                $scope.pictures=["../images/ncontent/4.png","../images/ncontent/2.png","../images/ncontent/3.png"];
                $scope.plist=["为提高村民健康生活质量及加强卫生医疗知识，2016年10月20日，福通智联会同员岗社区卫生服务站在板桥村举办“秋冬季中医养生保健知识”健康讲座。",
                    "活动9：00开始，由福通智联工作人员主持，简单介绍了本次讲座的主要内容后，员岗社区中医师史医生正式开始讲座，讲解了秋季润燥食疗及穴位保健等中医知识。为加深村民对讲座内容的理解，安排了有奖问答环节，村民积极参与活动，工作人员为答对者送上奖品。讲座结束后，健康管家为“电子保姆”用户进行了健康随访，细心为他们测量血压及给予健康指导。",
                    "村民从这次讲座中汲取了实用的秋冬季中医养生保健知识，有利于预防秋冬季疾病及有助于改善身体健康情况。"
                ];
                break;
            case 7:
                $scope.title="员岗社区卫生服务站会同福通智联家庭服务中心开展义诊活动";
                $scope.time="2017-04-19";
                $scope.author="";
                $scope.pictures=["../images/ncontent/5.png"];
                $scope.plist=["2017年4月19日，员岗社区卫生服务站会同福通智联家庭服务中心在板桥村村委开展义诊活动，不少村民前来参加。",
                    "福通智联工作员全力协助社区卫生服务中心开展活动，为村民发放体检报告、测量血压血糖，以及登记相关信息，卫生服务中心医生为村民进行报告解读及提供健康指导。",
                    "员岗社区卫生服务站与福通智联合作，为村民送来了健康，为他们的身体健康保驾护航！"
                ];
                break;
            case 8:
                $scope.title="福通智联会同南村社区卫生服务中心开展免费体检活动";
                $scope.time="2017-04-19";
                $scope.author="";
                $scope.pictures=["../images/ncontent/7.png"];
                $scope.plist=["2017年3月24-25日，南村社区卫生服务中心联合广州市番禺区福通智联家庭服务中心工作人员在江南村老年人活动中心开展体检活动，60岁以 上的老年人可免费参加，现场有专业的医护人员为他们进行身体检查。",
                    "本次体检活动项目有测血压、血糖、心电图、B超、尿常规等，整个活动 有序开展。福通智联工作人员主要负责维持现场秩序，协助老人测量血 压、血糖，与老人亲切交谈互动，工作得到村民及社区卫生服务中心的 人员肯定，服务中心相关负责人表示，希望以后可以再次合作共同开展 活动。（文/戴静）"
                ];
                break;
            case 9:
                $scope.title="福通智联协助板桥村开展年度体检活动";
                $scope.time="2017-03-17";
                $scope.author="";
                $scope.pictures=[""];
                $scope.plist=["2017年3月17日，南村镇社区卫生服务中心在板桥村为村民进行免费年度体检，福通智联家庭服务中心提供协助，有100名老人前来体检。",
                    "本次体检项目有测量血压、血糖，及心电图、B超、尿常规等多项检查，较全面了解老人的健康情况。福通智联工作人员主要负责协助登记资料、测量血压、引导老人到不同的摊位进行体检及维持现场秩序，期间详细询问老人的健康情况。部分老人反映，最近身体总是不舒服，但一直没能去看医生，现在可以免费体检，实在太好了。",
                    "老人上了年纪，身体机能老化，通常会出现各种问题，但有些老人不重视，社区卫生服务站定期到村委为他们免费体检，了解他们的健康情况，起到对一些疾病早发现早治疗的效果，在一定程度上增强了老人的健康意识。（文/潘智毅)"
                ];
                break;
            case 10:
                $scope.title="雅居乐颐乐站-健康之家正式启动！";
                $scope.time="2016-11-24";
                $scope.author="";
                $scope.pictures=[""];
                $scope.plist=["11月24日，雅居乐颐乐站-健康之家正式启动！当天，有不少社区老人来体验各种理疗服务，受到老人的好评。",
                    "雅居乐颐乐站-健康之家是南村镇政府、雅居乐社区居委、雅居乐社区老年人协会与福通智联家庭服务中心共建的健康享老服务平台。通过在社区内建设智慧驿站，打造成社区健康养老服务的场所、老年人健康和交流的窗口。",
                    "为体现党和政府关爱老人晚年生活，2017年2月16日，南村镇敬老院联合福通智联家庭服务中心，为院内50名老人发放“幸福手环”及为其开通服务。",
                    "敬老院现场，工作人员为老人发放手环，进行功能介绍及示范操作过程，只要用手机扫一扫手环上的二维码便会马上显示老人的姓名、家庭地址、联系家属、联系电话等信息，可以及时通知其家人，或者拨打“一键帮助”的电话号码，后台系统将自动挂断，无需支付电话费，工作人员马上回电了解情况，确认老人的位置及需求后提供信息连接帮助。",
                    "幸福手环操作简单，具有身份认证、名片信息、定位功能、服务确认、门禁应用等功能，并且防水、防震、耐磨，辅以智能芯片支持为老服务近距离嘀卡确认、进出老年人公共场所及设备嘀卡使用的应用，让更多的人参与到爱老敬老的活动中来，实现 “一方有难，八方支援”，安全将老人送回家，共同打造“政府显关爱、社会献爱心”的公益平台，为有需求的老人创造一个友好互助的社会环境。这是采用“互联网+”服务模式，把医养结合一体化逐步在各个敬老院推广使用。"
                ];
                break;
            case 11:
                $scope.title="坑头村颐乐站健康之家正式投入使用";
                $scope.time="2016-01-15";
                $scope.author="";
                $scope.pictures=["../images/ncontent/6.png"];
                $scope.plist=["2016年11月15日，南村镇坑头村颐乐站健康之家正式投诉使用了！村委领导陈书记、负责治安及民政的陈主任、福通智联家庭服务中心、福通智联家庭服务中心有关负责人以及村39位老人参加了开启活动。",
                    "9：30活动正式开始，首先由福通智联家庭服务中心有关人员介绍福来智库专家谢医生，然后谢医生从衣、食、住、行四个方面进行健康讲座，内容贴近生活、语言通俗易懂、轻松幽默，引起了老人的兴趣，学习气氛良好，让他们受益匪浅，纷纷为谢医生的讲解点头称赞，更有村民主动询问下次是否还有类似的讲座。",
                    "接着，福通智联家庭服务中心何主任发表了讲话，介绍了健康之家建设情况及服务功能，同时感谢今天到场支持的老人，并表示健康之家会不断完善。随后，工作人员为老人派发礼物。最后，福通智联家庭服务中心健康管家根据老人的情况指导他们体验红外线足疗、按摩等理疗服务，老人们都表示很舒服很满意。",
                    "健康之家是坑头村颐乐站的升级改造，由南村商会及村委共同出资，由福通智联家庭服务中心负责具体运行管理，位于坑头村老年人文化中心一楼，约60平方米，内设有远红外线石足疗桶、红外线保健仪、按摩躺椅、血压测量仪等设备，可提供理疗服务、健康咨询、健康指导、电子保姆及健康包服务咨询、心理慰藉以及建立个人档案等服务，免费为村60岁以上老人开放使用。"
                ];
                break;
            case 12:
                $scope.title="番禺区“五社联动”进南村，福来送上爱心“电子保姆”";
                $scope.time="2016-10-31";
                $scope.author="";
                $scope.pictures=["../images/ncontent/7.png","../images/ncontent/8.png","../images/ncontent/9.png","../images/ncontent/dianzi.png"];
                $scope.plist=["2016年10月31日，番禺区社会组织联合会、番禺区南村总商会、番禺区南村镇慈善会、番禺区南村镇雅居乐社区党委等共同举办了“五社联动”公益生态圈建设项目暨雅居乐社区党委“关爱互助，服务到家”活动启动仪式，福通智联作为协办单位之一参加了本次公益活动。",
                    "活动开始，首先由南村镇社联会会长、南村总商会会长王锦荣等领导致辞，接着举行本次活动启动仪式、捐赠仪式，以及“电子保姆”赠送仪式，然后是丰富多彩的歌舞、小品节目，以及有奖问答等环节，另外，还为居民设置了义诊、为老服务宣传、家综宣传、义工招募、党委志愿者招聘等摊位。",
                    "活动内容非常贴近社区长者生活，尤其是福通智联工作人员表演的小品《我家有个电子保姆》充分表达了长者在日常生活中遇到的种种不便，通过“电子保姆”服务让他们享受到互联网技术所带来的优质、有保障的老年生活，此小品受到活动参与者的欢迎，接下来的有奖问答、舞蹈表演等环节把活动的气氛逐渐推向高潮。",
                    "本次活动吸引了不少本地媒体的关注，其中番禺电视台等媒体针对福通智联创新的养老服务模式进行了采访；与会领导、嘉宾在参观福通智联展位后，对此模式表示认可，希望福通智联能在今后南村为老服务的建设中承担更重要的角色。"
                ];
                break;
            case 13:
                $scope.title="不怕走丢！政府免费为660名失智老人提供“智能黄手环”！";
                $scope.time="2017-02-25";
                $scope.author="番禺日报";
                $scope.pictures=[""];
                $scope.plist=["福利来啦！最近我区政府为660名失智老人，免费提供“智能黄手环”，具备“双卫星定位、一键SOS求助”等功能。现在失智老人戴上这“能黄手环”后，就可以“圈定”老人的安全，为他们的安全戴上“安全帽”。",
                    "目前我国失智老年人",
                    "比例已超过5%",
                    "据权威调查数据显示，目前我国失智老年人比例已超过5%，大多数的老年痴呆病属于慢性进展性疾病，早期患者会出现记忆、思维、语言、视空间辨认功能的减退，到中期逐步转化为情绪焦虑、暴躁等症状，晚期会出现身体各项机能的衰减和丧失，患者丧失正常工作和生活的能力。据统计，60周岁及以上的人群中，每增长5岁患病率就增加1倍，患者通常带病生存期为5~10年甚至更长，每年均有多起失智老年人因走失而死亡的案例 ，给社会和家庭带来沉重的负担。",
                    "为全区660名失智老人",
                    "免费发放“智能黄手环”",
"区民政局、区老龄办决定采取政府购买服务的形式，联合广州市番禺区福通智联家庭服务中心，向全区自愿申报的660多名失智老人发放“智能黄手环”，为有需求的患有记忆障碍、认知障碍或患有老年痴呆的失智老年人免费配备防走失手环一个，帮助（辅助）家庭解决失智老年人走失问题，随时监测掌握老年人的行动轨迹。",
                    "区民政局有关领导表示，向全区失智老人发放“智能黄手环”，这种由政府购买，公司提供后台互联网技术和跟踪服务的做法，目的是要解决好老人走失问题，让家属随时了解和掌握老年人的活动轨迹。同时通过信息采集建立失智老年人信息数据库，对失智老年人群体的身体状况、行为轨迹、精神状态等进行分析研究，为疾病的提前预防、患病后的防治、有针对性地服务失智老年人提供切实可行的依据。同时采用“互联网+”服务模式，为老人们提供“养老服务、健康服务、医养结合”一体化的服务。",
                    "“智能手环”“圈定”老人安全",
                    "据负责提供技术帮助的广州市番禺区福通智联家庭服务中心技术人员介绍，这种智能手环主要有“双卫星定位、一键SOS求助、电子围栏”等功能，而且具有4天超长待机、防水防摔防跌落等特点。智能手环上的一键SOS求助功能，老人遇到险情，只需一按手环，立即发送求救信号和定位信息到家人手机和福通智联的平台上，让家人和志愿者可以及时施救。尤其是电子围栏功能，更是多点电子安全围栏，老人一旦走出围栏范围，手环马上发送警报给家人和福通智联的平台，让家人可以及时知道老人动向。",
"文：钟世伟",
                "编辑| 大麦"
                ];
                break;
            case 14:
                $scope.title="南村镇敬老院为老人开通“幸福手环”";
                $scope.time="2017-02-21";
                $scope.author="本报讯";
                $scope.pictures=["../images/ncontent/xingfu.jpg"];
                $scope.plist=[
                    "本报讯  （记者钟世伟  通讯员黎沛基）扫一扫手中佩戴手环中的二维码，手中可以立刻显示出老人的姓名、家庭地址、联系家属、联系电话等各种信息，再拨打“一键帮助”的电话号码接通后，后台系统将自动挂断，无需支付电话费，后台系统接到电话后，会在一分钟之内回拨电话过问老人有什么需要帮助的，并准确定位到老人所处的位置。这是记者2月16日在南村镇敬老院体验刚刚为老人们开通“幸福手环”的情景（见图，钟世伟摄）。据悉，这是我区首家为老人开通“幸福手环”的敬老院。",
"南村镇敬老院现有100多名老人，其中有50多名生活可自理和半自理，为打造“政府显关爱、社会献爱心”的公益平台，便于老人管理，方便爱心人士为走失老人及时提供位置信息，让老人开开心心出门，平平安安回家，同时达到统一老年人标识，为有需求的老人创造一个友好互助的社会环境，辅以智能芯片支持为老服务近距离嘀卡确认、进出老年人公共场所及设备嘀卡使用的应用，让更多的人参与到爱老敬老爱的活动中来， 南村镇敬老院与广州市番禺区福通智联家庭服务中心合作，先期为50名老人定制了“幸福手环”，并在2月16日正式开通。",
"南村镇敬老院副院长莫嘉文说，为老人配戴“幸福手环”，除了方便爱心人士为万一走失老人及时提供位置信息，实现了身份认证、名片信息、定位功能、服务确认、门禁应用等功能，以二维码形式内嵌老人身份信息；还能让院内老人外出有身份的标识，能记录老人进出敬老院，能查询老人的基本信息资料，能让外出的老人在危险时，热心人士能通过扫码迅速联系到服务机构或者通知到家人，并能知道老人所在的位置。",
　　"负责提供技术帮助的广州市番禺区福通智联家庭服务中心技术人员表示，佩戴上“幸福手环”，只要扫一扫手环中的二维码，路遇迷路老人、小孩，旁人通过手环底部外侧24小时紧急救援热线号码，将手环上二维码下面的ID号和老人位置报24小时服务中心即可通知到家人。",
　　"据介绍，“幸福手环”功能定位与使用方法较为简单，具有二维码信息，手环上有唯一的ID号、紧急救助电话，24小时紧急救援热线号码；而使用方法是，关爱长者的热心人士，可通过手机扫描需求助长者手环上的二维码，手机上会自动显示相应的紧急救援电话，如有标志性建筑物可输入或拍摄上传，即时拨打报24小时服务中心即可通知到家人。",
　　"广州市番禺区福通智联家庭服务中心表示，“幸福手环”简单又实用，只需手上佩戴，不但防水、防震、耐磨，还记录详细的个人基本信息，走失时只需扫一扫，立刻可以通知家人及服务机构或服务平台；扫码后能联系平台，实时知道用户位置及需求，实现 “一方有难，八方支援”；同时采用“互联网+”服务模式，为老人们提供“养老服务、健康服务、医养结合”一体化的服务，中心将逐步在各个敬老院推广使用“幸福手环”。"
                ];
                break;
            default:
                $scope.title="雅居乐健康之家开展第四期健康讲座";
                $scope.time="2017-04-26";
                $scope.author="";
                $scope.pictures=["../images/ncontent/pic111.png"];
                $scope.plist=["2017年4月26日，雅居乐健康之家开展第四期健康讲座，主题为《老年人心理健康》，由福通智联家庭服务中心健康管家邱医生主讲，邀请员岗社区的医护人员参与，现场有28位居民前来听课。",
                    "讲座前，员岗社区医护人员在健康之家门口设点为居民测量血糖，然后为他们送上了早餐，接着，由福通智联工作人员引领他们就坐及派发讲座内容介绍，期间为他们测量血压。到了9:40，讲座正式开始，邱医生为大家详细讲解了健康的定义、心理健康的五个原则、老年人的五种心理变化、长寿老人的六大心理特征、老年人不良情绪的疏导等内容，在场居民认真听课，积极向医生提问，诉说自己的心事，医生耐心倾听并给出安慰和建议。",
                    "本次健康讲座向居民传播了心理健康保健知识，解答了老人的疑问，进行了适当的心理疏导，从而有助于提高他们的生活质量，得到居民的热烈反响。"
                ];
        }

    }])
    /*--------------- 概况咨询列表 ----------------*/
    .controller('gaikuangNewsListCtrl', ['$scope', '$http',"$state","$cookies",function ($scope, $http,$state,$cookies) {
        $scope.teamName=$cookies.get("teamName");
        /*分页*/
        var  page = {
            "pageId":"",
            "data":null,
            "maxshowpageitem":5,//最多显示的页码个数
            "pagelistcount":10,//每一页显示的内容条数
            "init":function(listCount,currentPage,options){
                this.data=options.data,
                    this.pageId=options.id,
                    this.maxshowpageitem=options.maxshowpageitem,//最多显示的页码个数
                    this.pagelistcount=options.pagelistcount//每一页显示的内容条数
                page.initPage(listCount,currentPage);
            },
            /**
             * 初始化数据处理
             * @param listCount 列表总量
             * @param currentPage 当前页
             */
            "initPage":function(listCount,currentPage){
                var maxshowpageitem = page.maxshowpageitem;
                if(maxshowpageitem!=null&&maxshowpageitem>0&&maxshowpageitem!=""){
                    page.maxshowpageitem = maxshowpageitem;
                }
                var pagelistcount = page.pagelistcount;
                if(pagelistcount!=null&&pagelistcount>0&&pagelistcount!=""){
                    page.pagelistcount = pagelistcount;
                }
                page.pagelistcount=pagelistcount;
                if(listCount<0){
                    listCount = 0;
                }
                if(currentPage<=0){
                    currentPage=1;
                }

                page.setPageListCount(listCount,currentPage);
            },
            /**
             * 初始化分页界面
             * @param listCount 列表总量
             */
            "initWithUl":function(listCount,currentPage){
                var pageCount = 1;
                if(listCount>=0){
                    var pageCount = listCount%page.pagelistcount>0?parseInt(listCount/page.pagelistcount)+1:parseInt(listCount/page.pagelistcount);
                }
                var appendStr = page.getPageListModel(pageCount,currentPage);
                $("#"+page.pageId).html(appendStr);
            },
            /**
             * 设置列表总量和当前页码
             * @param listCount 列表总量
             * @param currentPage 当前页码
             */
            "setPageListCount":function(listCount,currentPage){
                listCount = parseInt(listCount);
                currentPage = parseInt(currentPage);
                page.initWithUl(listCount,currentPage);
                page.initPageEvent(listCount);
                page.viewPage(currentPage,listCount,page.pagelistcount,page.data)
//      fun(currentPage);
            },
            //页面显示功能
            "viewPage":function (currentPage,listCount,pagelistcount,data){
                var NUM=listCount%pagelistcount==0?listCount/pagelistcount:parseInt(listCount/pagelistcount)+1;
                if(currentPage==NUM){
                    var result=data.slice((currentPage-1)* pagelistcount,data.length);
                }
                else{
                    var result=data.slice((currentPage-1)*pagelistcount,(currentPage-1)*pagelistcount+pagelistcount);
                }
                options.callBack(result);
            },
            "initPageEvent":function(listCount){
                $("#"+page.pageId +">li[class='pageItem']").on("click",function(){
                    page.setPageListCount(listCount,$(this).attr("page-data"),page.fun);
                });
            },
            "getPageListModel":function(pageCount,currentPage){
                var prePage = currentPage-1;
                var nextPage = currentPage+1;
                var prePageClass ="pageItem";
                var nextPageClass = "pageItem";
                if(prePage<=0){
                    prePageClass="pageItemDisable";
                }
                if(nextPage>pageCount){
                    nextPageClass="pageItemDisable";
                }
                var appendStr ="";
                appendStr+="<li style='visibility:hidden;' class='"+prePageClass+"' page-data='1' page-rel='firstpage'>首页</li>";
                appendStr+="<li style='visibility:hidden;' class='"+prePageClass+"' page-data='"+prePage+"' page-rel='prepage'>&lt;上一页</li>";
                var miniPageNumber = 1;
                if(currentPage-parseInt(page.maxshowpageitem/2)>0&&currentPage+parseInt(page.maxshowpageitem/2)<=pageCount){
                    miniPageNumber = currentPage-parseInt(page.maxshowpageitem/2);
                }else if(currentPage-parseInt(page.maxshowpageitem/2)>0&&currentPage+parseInt(page.maxshowpageitem/2)>pageCount){
                    miniPageNumber = pageCount-page.maxshowpageitem+1;
                    if(miniPageNumber<=0){
                        miniPageNumber=1;
                    }
                }
                var showPageNum = parseInt(page.maxshowpageitem);
                if(pageCount<showPageNum){
                    showPageNum = pageCount;
                }
                for(var i=0;i<showPageNum;i++){
                    var pageNumber = miniPageNumber++;
                    var itemPageClass = "pageItem";
                    if(pageNumber==currentPage){
                        itemPageClass = "active";
                    }

                    appendStr+="<li class='"+itemPageClass+"' page-data='"+pageNumber+"' page-rel='itempage'>"+pageNumber+"</li>";
                }
                appendStr+="<li style='display:none;' class='"+nextPageClass+"' page-data='"+nextPage+"' page-rel='nextpage'>下一页&gt;</li>";
                appendStr+="<li style='display:none;' class='"+nextPageClass+"' page-data='"+pageCount+"' page-rel='lastpage'>尾页</li>";
                return appendStr;

            }
        };
        /*分页结束*/
        var datas=[
            {"did":1,"name":"雅居乐健康之家开展第四期健康讲座<span>2017-04-26</span>","price":36,"img_sm":"p0281.jpg","material":"明虾、番茄酱、白糖、白醋、葱、姜、淀粉"},
            {"did":2,"name":"雅居乐健康之家开展第三期健康讲座<span>2017-03-23</span>","price":16.5,"img_sm":"p2679.jpg","material":"切片吐司、紫薯、铁棍山药、糖桂花、炼乳"},
            {"did":3,"name":"雅居乐健康之家举行健康讲座<span>2017-02-23</span>","price":32,"img_sm":"p8489.jpg","material":"三黄鸡、杭椒、干红椒、新鲜小米椒、麻椒、八角、香叶、葱、姜、生抽"},
            {"did":4,"name":"福通智联会同南村社区卫生服务中心开展免费体检活动 <span>2017-01-13</span>","price":36,"img_sm":"p0281.jpg","material":"明虾、番茄酱、白糖、白醋、葱、姜、淀粉"},
            {"did":5,"name":"为走失老人配上智能黄手环 <span>2017-04-14</span>","price":16.5,"img_sm":"p2679.jpg","material":"切片吐司、紫薯、铁棍山药、糖桂花、炼乳"},
            {"did":6,"name":"板桥村委联同福通智联家庭服务中心举办健康讲座<span>2016-10-20</span>","price":32,"img_sm":"p8489.jpg","material":"三黄鸡、杭椒、干红椒、新鲜小米椒、麻椒、八角、香叶、葱、姜、生抽"},
            {"did":7,"name":"员岗社区卫生服务站会同福通智联家庭服务中心开展义诊活动<span>2016-10-20</span>","price":36,"img_sm":"p0281.jpg","material":"明虾、番茄酱、白糖、白醋、葱、姜、淀粉"},
            {"did":8,"name":"福通智联会同南村社区卫生服务中心开展免费体检活动<span>2017-03-24</span>","price":16.5,"img_sm":"p2679.jpg","material":"切片吐司、紫薯、铁棍山药、糖桂花、炼乳"},
            {"did":9,"name":"福通智联协助板桥村开展年度体检活动<span>2017-03-17</span>","price":32,"img_sm":"p8489.jpg","material":"三黄鸡、杭椒、干红椒、新鲜小米椒、麻椒、八角、香叶、葱、姜、生抽"},
            {"did":10,"name":"雅居乐颐乐站-健康之家正式启动！<span>2016-11-24</span>","price":36,"img_sm":"p0281.jpg","material":"明虾、番茄酱、白糖、白醋、葱、姜、淀粉"},
            {"did":11,"name":"坑头村颐乐站健康之家正式投入使用<span>2016-11-15</span>","price":36,"img_sm":"p0281.jpg","material":"明虾、番茄酱、白糖、白醋、葱、姜、淀粉"},
            {"did":12,"name":"番禺区“五社联动”进南村，福来送上爱心“电子保姆”<span>2016-10-31</span>","price":16.5,"img_sm":"p2679.jpg","material":"切片吐司、紫薯、铁棍山药、糖桂花、炼乳"},
            {"did":13,"name":"不怕走丢！政府免费为660名失智老人提供“智能黄手环”！<span>2017-02-25 </span>","price":32,"img_sm":"p8489.jpg","material":"三黄鸡、杭椒、干红椒、新鲜小米椒、麻椒、八角、香叶、葱、姜、生抽"}
        ];
        var options={
            "id":"pages",//显示页码的元素
            "data":datas,//显示数据
            "maxshowpageitem":3,//最多显示的页码个数
            "pagelistcount":5,//每页显示数据个数
            "callBack":function(result){
                var cHtml="";
                //console.log(result);
                for(var i=0;i<result.length;i++){
                    cHtml+="<li data-did="+result[i].did+">"+ result[i].name+"</li>";//处理数据
                }
                $("#news").html(cHtml);//将数据增加到页面中
            }
        };
        page.init(datas.length,1,options);
        var lis=$("#news li");
        for(var i=0;i<datas.length;i++){
            (function(a){
                $("#news").on("click",'li',function(){
                    $state.go("gaikuangNewsArticle",{did:$(this).data('did')});
                });
            })(i);

        }
    }])
    /*--------------- 点餐2 ----------------*/
    .controller('order2Ctrl', ['$scope','$http',"$cookies","$stateParams",function ($scope,$http,$cookies,$stateParams) {
        //左边菜单亮色
        if($stateParams.active=='useDetail'){
            $scope.useDetail=true;
            $scope.useList=false;
        }else{
            $scope.useList=true;
            $scope.useDetail=false;
        }
        /*点击关闭按钮*/
        $scope.goBack=function(){
            window.history.go(-1);
        }
        /*取出个人信息*/
        if($cookies.get("personInfo")){
            $scope.data=JSON.parse($cookies.get("personInfo"));
            if($scope.data.disease){
                $scope.gaoImg=true;
            }else{
                $scope.gaoImg=false;
            }
        }
        //默认餐别
        $scope.currentTab = 2;
        /*点击早中晚餐后的切换*/
        $scope.onClickTab = function (tab) {
            $scope.currentTab = tab.mealType.id;
            angular.forEach(tab.datas,function(data){
                data.mealTypeId=tab.mealType.id;
            });
            $scope.list=tab.datas;
            $cookies.put("mealTypeId",tab.mealType.id);
        }
        $scope.isActiveTab = function(tabUrl) {
            return tabUrl == $scope.currentTab;
        }
        /*保存已点*/
        $scope.list2=[];
        $scope.number=0;
        $("#quorder").css("background",'#999999');
        /*点击添加一份*/
        $scope.save=function(item){
            $("#maskDisease .box-second").click(function(){
                $("#maskDisease").css({"display":"none"});
            });
            $("#maskDisease .no").click(function(){
                $("#maskDisease").css({"display":"none"});
            });
            /*判断是否疾病不适*/
            /*开始*/
            if(Boolean(item.disease)==false){
                var flag=true;
                angular.forEach($scope.list2,function(data,index){
                    if(data.mealDate==item.mealDate){
                        if(data.mealTypeId==item.mealTypeId){
                            $scope.list2.splice(index,1,item);
                            flag=false;
                        }
                    }
                });
                if(flag){
                    $("#kong").css("display","none");
                    $scope.list2.push(item);
                }
                /*颜色和数量*/
                if($scope.list2.length==0){
                    $("#quorder").css("background",'#999999');
                    $("#kong").css("display","block");
                    $scope.number=0;
                }else{
                    $("#quorder").css("background",'#ff7e00');
                    $("#kong").css("display","none");
                    $scope.number=$scope.list2.length;
                }
            }else{
                if($scope.data.disease){
                    $scope.bushi="不适："+$scope.data.disease;
                }
                $scope.bushiname=item.option.name.substr(0,item.option.name.indexOf(")")+1);
                $("#maskDisease").css({"display":"block"});
                /*继续点餐加入*/
                $scope.yes=function(){
                    $("#maskDisease").css({"display":"none"});
                    var flag=true;
                    angular.forEach($scope.list2,function(data,index){
                        if(data.mealDate==item.mealDate){
                            if(data.mealTypeId==item.mealTypeId){
                                $scope.list2.splice(index,1,item);
                                flag=false;
                            }
                        }
                    });
                    if(flag){
                        $("#kong").css("display","none");
                        $scope.list2.push(item);
                    }
                    /*颜色和数量*/
                    if($scope.list2.length==0){
                        $("#quorder").css("background",'#999999');
                        $("#kong").css("display","block");
                        $scope.number=0;
                    }else{
                        $("#quorder").css("background",'#ff7e00');
                        $("#kong").css("display","none");
                        $scope.number=$scope.list2.length;
                    }
                }
            }
            /*结束*/
        }
        //删除已点
        $scope.delete=function(item){
            angular.forEach($scope.list2,function(data,index){
                if(JSON.stringify(data)==JSON.stringify(item)){
                    $scope.list2.splice(index,1);
                }
            });
            $scope.number=$scope.list2.length;
            if($scope.number==0){
                $("#quorder").css("background",'#999999');
                $("#kong").css("display","block");
            }
        }
        /*去下单*/
        $scope.orderFlag=true;//只能下一次单的判断
        $scope.quorder=function(){
            if($scope.list2.length==0) return ;
            /*判断订单池有无菜单*/
            if($scope.orderFlag==true){//可以下单
                $scope.orderFlag=false;//下完单不可在点击
                if($scope.list2.length!=0){//有订单可以下
                    $("#maskQuorder").css("display","block");
                    $scope.second=3;
                    /*弹出下单成功*/
                    var myTimer=setInterval(function(){
                        if($scope.second>0){
                            $scope.second=$scope.second-1;
                            $("#second").html($scope.second);
                        }else{
                            clearInterval(myTimer);
                            //下单成功
                            window.history.go(-1);
                        }
                    },1000);
                    var arr=[];
                    for(var i=0;i<$scope.list2.length;i++){
                        var obj={};
                        obj.teamId=$cookies.get("teamId");
                        obj.mealDate=$scope.list2[i].mealDate;
                        obj.mealTypeId=$scope.list2[i].mealTypeId;
                        obj.mealId=$scope.list2[i].option.id;
                        arr[i]=obj;
                    }
                    var params={
                        personId:$cookies.get("personId"),/*会话中的circleId*/
                        commands:arr
                    };
                    $http({
                            url:"../../app/addOrder",
                            method:"POST",
                            data:params
                        }
                    ).then(function(response){

                        }).catch(function(error){
                            console.log(error);
                        });
                }
            }

        }
        /*请求得到早中晚餐按钮及各餐菜谱*/
        $http.get("../../app/findAllDatas",{params:{
            circleId:$cookies.get("circleId"),/*会话中的circleId*/
            personId:$cookies.get("personId"), /*会话中的personId*/
            dateStr:getnextFormatDate(getNowFormatDate("YYYY-MM-DD"),"YYYY-MM-DD")+" "+"00:00:00"/*界面选择的时间，格式：yyyy-MM-dd HH:mm:ss 字符串*/
        }}).then(function(response){
            var list=response.data;
            for(var i=0;i<list.length;i++){
                for(var j=0;j<list[i].datas.length;j++){
                    if(Boolean(list[i].datas[j].enable)==false){
                        for(var t=0;t<list[i].datas.length;t++){
                            list[i].datas[t].enable=false;
                        }
                    }
                }
            }
            angular.forEach(list[1].datas,function(data){
               data.mealTypeId=list[1].mealType.id;
            });
            $scope.list=list[1].datas;
            $scope.tabs=list;
            $cookies.put("mealTypeId",list[1].mealType.id);
        }).catch(function(error){
            console.log(error);
        });
        /*助餐点工作站对象*/
        $http.get("../../app/findHnxftSubjectModel",{params:{
            circleId:$cookies.get("circleId"),/*会话中的circleId*/
            personId:$cookies.get("personId")/*此参数有一些疑问，具体来说应该是会话中的personId*/
            }}).then(function(response){
            $scope.info=response.data;
        }).catch(function(error){
            console.log(error);
        });
        /*时间选择弹框*/
        /*$scope.visible=true;
        $scope.toggle=function(){
            $scope.visible=!$scope.visible;
            $("#today").val($("#cTime").html());
        }*/
        /*时间后一天*/
        $('#next').click(function() {
            var date=$("#cTime").html();
            date=date+" 00:00:00";
            //日期 转 时间戳
            var ms=Number($.timeStampDate(date,false))+86400;   //
            //时间戳 转 日期
            date=$.timeStampDate(ms+"",true,"YYYY-MM-DD");    //得到 2017-11-16 10:35:22
            $("#cTime").html(date);
            $http.get("../../app/findAllDatas",{params:{
                circleId:$cookies.get("circleId"),/*会话中的circleId*/
                personId:$cookies.get("personId"), /*此参数有一些疑问，具体来说应该是会话中的personId*/
                dateStr:date+" "+"00:00:00"/*getNowFormatDate("HH:mm:ss")*//*界面选择的时间，格式：yyyy-MM-dd HH:mm:ss 字符串*/
            }}).then(function(response){
                var list=response.data;
                for(var i=0;i<list.length;i++){
                    for(var j=0;j<list[i].datas.length;j++){
                        if(Boolean(list[i].datas[j].enable)==false){
                            for(var t=0;t<list[i].datas.length;t++){
                                list[i].datas[t].enable=false;
                            }
                        }
                    }
                }
                angular.forEach(list[$cookies.get("mealTypeId")-1].datas,function(data){
                    data.mealTypeId=$cookies.get("mealTypeId");
                });
                $scope.list=list[$cookies.get("mealTypeId")-1].datas;
                $scope.tabs=list;
            }).catch(function(error){
                console.log(error);
            });
        });
        /*时间前一天*/
        $('#prev').click(function() {
            var date=$("#cTime").html();
            if(date==getNowFormatDate("YYYY-MM-DD")){
            }else{
                date=date+" 00:00:00";
                //日期 转 时间戳
                var ms=Number($.timeStampDate(date,false))-86400;   //得到 1513391722
                //时间戳 转 日期
                date=$.timeStampDate(ms+"",true,"YYYY-MM-DD");    //得到 2017-11-16 10:35:22
                $("#cTime").html(date);
                $http.get("../../app/findAllDatas",{params:{
                    circleId:$cookies.get("circleId"),/*会话中的circleId*/
                    personId:$cookies.get("personId"), /*此参数有一些疑问，具体来说应该是会话中的personId*/
                    dateStr:date+" "+"00:00:00"/*getNowFormatDate("HH:mm:ss")*//*界面选择的时间，格式：yyyy-MM-dd HH:mm:ss 字符串*/
                }}).then(function(response){
                    var list=response.data;
                    for(var i=0;i<list.length;i++){
                        for(var j=0;j<list[i].datas.length;j++){
                            if(Boolean(list[i].datas[j].enable)==false){
                                for(var t=0;t<list[i].datas.length;t++){
                                    list[i].datas[t].enable=false;
                                }
                            }
                        }
                    }
                    angular.forEach(list[$cookies.get("mealTypeId")-1].datas,function(data){
                        data.mealTypeId=$cookies.get("mealTypeId");
                    });
                    $scope.list=list[$cookies.get("mealTypeId")-1].datas;
                    $scope.tabs=list;
                }).catch(function(error){
                    console.log(error);
                });
            }
        });
        /*初始化时间*/
        var cTime=getnextFormatDate(getNowFormatDate(),"YYYY-MM-DD");
        $("#cTime").html(cTime);
        /*时间函数*/
        function getNowFormatDate(format) {
            var date = new Date();
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if(month >= 1 && month <= 9) {
                month ="0" + month;
            }
            if(strDate >= 0 && strDate <= 9) {
                strDate ="0" + strDate;
            }
            if(format=="YYYY-MM-DD"){
                var currentdate = date.getFullYear() + "-" + month + "-" + strDate;
            }else if(format=="HH:mm:ss"){
                var currentdate =date.getHours() + ":" + date.getMinutes()
                    + ":" + date.getSeconds();
            }else{
                var currentdate = date.getFullYear() + "-" + month + "-" + strDate
                    +" " + date.getHours() + ":" + date.getMinutes()
                    + ":" + date.getSeconds();
            }
            return currentdate;
        }
        function getnextFormatDate(d,format) {
            var date = new Date(d);
            date = +date + 1000*60*60*24;
            date = new Date(date);
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if(month >= 1 && month <= 9) {
                month ="0" + month;
            }
            if(strDate >= 0 && strDate <= 9) {
                strDate ="0" + strDate;
            }
            var currentdate;
            if(format=="YYYY-MM-DD"){
                currentdate = date.getFullYear() + "-" + month + "-" + strDate;
            }else if(format=="HH:mm:ss"){
                currentdate =date.getHours() + ":" + date.getMinutes()
                    + ":" + date.getSeconds();
            }else{
                currentdate = date.getFullYear() + "-" + month + "-" + strDate
                    +" " + date.getHours() + ":" + date.getMinutes()
                    + ":" + date.getSeconds();
            }
            return currentdate;
        }
    }])
    /*--------------- 概况-内容页----------------*/
    .controller('gaikuangContentCtrl', ['$scope', '$http', function ($scope, $http) {
    }])
    /*--------------- 查询-首页----------------*/
    .controller('selectIndexCtrl', ["$scope","$cookies","$state","$http", function ($scope,$cookies,$state,$http) {
        $scope.teamName=$cookies.get("teamName");
        /*个人明细start*/
        /*查询助餐点工作站对象消费明细(近十天内)*/
        $http.get("../../app/findHnxftOrderModelListBySubject",{params:{
            teamId:$cookies.get("teamId")
        }}).then(function(response){
            $scope.items=response.data;
        }).catch(function(error){
            console.log("失败");
        });
        /*输入手机号按确定*/
        $scope.sure=function(){
            if($scope.phNumber){
                $http.get("../../app/findSubjectByMobile",{
                    params:{
                        teamId:$cookies.get("teamId"),
                        mobile:$scope.phNumber
                    }
                }).then(function(response){
                    if(Boolean(response.data)==false){
                        $scope.alText="没有这个用户！";
                    }else{
                        $scope.alText="登录成功";
                        for(var i=0;i<$scope.items.length;i++){
                            if($scope.items[i].mobile==$scope.phNumber){
                                localStorage.setItem("blist",JSON.stringify($scope.items[i].list));
                                var name=$scope.items[i].subjectName;
                                var balance=$scope.items[i].balance;
                                var ownSum=$scope.items[i].ownExpenseSum;
                                var govSum=$scope.items[i].govCostSum;
                                var sTName=response.data.subjectInfo.subjectTypeName;
                                $state.go("selectGrmx",{name:name,balance:balance,govSum:govSum,ownSum:ownSum,sTName:sTName});
                            }
                        }
                    }
                }).catch(function(error){
                    $scope.alText="输入错误，请校正登录！";
                });
            }else{
                $scope.alText="请输入手机全位号/固话，再登录！";
            }
        }
        /*end*/
    }])
    /*--------------- 查询-助餐点----------------*/
    .controller('selectZcdCtrl', ['$scope', '$http',"$cookies","$state",function ($scope, $http,$cookies,$state) {
        $scope.meal="早餐";
        $scope.isTrue=function(mealTypeName){
            return mealTypeName==$scope.meal;
        }
        $scope.saveMeal=function(data){
            $scope.meal=data.mealTypeName;
            $scope.mealType=data;
            $scope.mealTypeId=data.id;
        }
        /*查找所有餐别类型*/
        $http.get("../../app/findAllMealType").then(function(result){
            $scope.item=result.data;
            $scope.mealTypeId=$scope.item[0].id;
            getAllOrder($scope.mealTypeId,getNowFormatDate("YYYY-MM-DD"));
        }).catch(function(){
            console.log("失败");
        });
        $scope.search=function(){
            getAllOrder($scope.mealTypeId,$("#selectTime").val());
        }
        /*查询助餐点工作站当餐订单汇总*/
        function getAllOrder(mealTypeId,time){
            $http.get("../../app/findHnxftOrderList",{
                params:{
                    teamId:$cookies.get("teamId"),
                    mealTypeId:mealTypeId,
                    time:time
                }
            }).then(function(result){
                $scope.HnxftOrderModel=result.data;
            }).catch(function(){
                console.log("失败");
            });
        }
        /*日期选择*/
        $("#selectTime").jeDate({
            isinitVal:true,
            isClear:false,
            ishmsVal:true,
            trigger:"click",
            minDate: '2016-06-16',
            format:"YYYY-MM-DD",
            zIndex:3000,
            choosefun: function(elem,datas,val){
                $scope.time=val.substr(0,10);
            },
            success:function(elem,date) {
            }
        });
        $scope.closed=function(){
            window.history.go(-1);
        }
        function getNowFormatDate(format){
            var date = new Date();
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if(month >= 1 && month <= 9) {
                month ="0" + month;
            }
            if(strDate >= 0 && strDate <= 9) {
                strDate ="0" + strDate;
            }
            var currentdate;
            if(format=="YYYY-MM-DD"){
                currentdate = date.getFullYear() + "-" + month + "-" + strDate;
            }else if(format=="HH:mm:ss"){
                currentdate =date.getHours() + ":" + date.getMinutes()
                    + ":" + date.getSeconds();
            }else{
                currentdate = date.getFullYear() + "-" + month + "-" + strDate
                    +" " + date.getHours() + ":" + date.getMinutes()
                    + ":" + date.getSeconds();
            }
            return currentdate;
        }
    }])
    /*--------------- 查询-个人明细----------------*/
    .controller('selectGrmxCtrl', ['$scope', '$http',"$cookies","$stateParams","$state",function ($scope, $http,$cookies,$stateParams,$state) {
        $scope.name=$stateParams.name;
        $scope.balance=Number($stateParams.balance).toFixed(2);
        $scope.govSum=Number($stateParams.govSum).toFixed(2);
        $scope.ownSum=Number($stateParams.ownSum).toFixed(2);
        $scope.sTName=$stateParams.sTName;
        $scope.list=JSON.parse(localStorage.getItem("blist"));
        $scope.closed=function(){
            window.history.go(-1);
            localStorage.removeItem("blist");
        }
    }])
    /*--------------- 个人明细用户列表----------------*/
    .controller('grmxListCtrl', ['$scope', '$http', function ($scope, $http) {

    }])
    /*--------------- 指导----------------*/
    .controller('guidanceCtrl', ['$scope', '$cookies', function ($scope, $cookies) {
        $scope.teamName=$cookies.get("teamName");
    }])
    /*--------------- 指导详情----------------*/
    .controller('gaoxueyaCtrl', ['$scope',"$stateParams", function ($scope,$stateParams) {
        if($stateParams.id==1){
            $scope.title="高血压饮食指导";
            $scope.imglist=['zhidao/img/5.jpg','zhidao/img/6.jpg','zhidao/img/7.jpg','zhidao/img/8.jpg'];
            $scope.content=["清淡饮食，少吃肥肉、肥肠等油腻食物，少吃动物内脏、蛋黄等高胆固醇食物及咖啡、浓茶等辛辣刺激性食物；饮食应有节，定时定量，不可过饥或过饱，不暴饮暴食。",
                "选择鱼肉、瘦猪肉、鸡肉、鸡蛋白、牛奶、大豆等富含优质蛋白质的食物；限制高糖食品，少吃甜的蛋糕、甜饼、甜点心、糖果等。",
                "控制食盐的摄入，每人每天摄入食盐量应控制在6g以下，少吃咸菜、咸肉、腐乳等含钠盐高的食物；多吃新鲜的时令蔬菜和水果，如芹菜、芦笋、茄子、萝卜、西红柿、香蕉、梨、柠檬等。",
                "提倡多吃粗粮、杂粮，如荞麦、燕麦、糙米、玉米等；戒烟戒酒，戒酒有困难的人也应限制饮酒。"];
        }else if($stateParams.id==2){
            $scope.title="糖尿病饮食指导";
            $scope.imglist=['zhidao/img/9.jpg','zhidao/img/10.jpg','zhidao/img/11.jpg','zhidao/img/12.jpg','zhidao/img/13.jpg'];
            $scope.content=[
                "饮食有节，定时定量，少食多餐，避免过饥过饱，避免暴饮暴食；避免进食含糖食物，如糖果、糕点、甜食、汽水等。",
                "少吃肥肉、动物内脏、蛋黄、红烧肉、猪蹄等食物含饱和脂肪和胆固醇高的肉类，可选择瘦猪肉、瘦牛肉、瘦羊肉、去皮鸡肉等低脂肪肉类；多吃新鲜蔬菜，如冬瓜、芦笋、香菇、萝卜、海带、韭菜、黄瓜、苋菜、空心菜、卷心菜、花椰菜、芹菜、菜心、番茄等。",
                "选择含糖低的水果，包括西瓜、草莓、香瓜、葡萄、樱桃、橙子、橘子、枇杷、梨、桃子、李子、石榴、柚子、苹果等；尽量不吃含糖量高的水果，如甘蔗、蜜枣等。",
                "多吃高纤维食物，如玉米、小麦等，以及豆类及豆制品，如大豆、黑豆、绿豆、豆腐、豆浆等。",
                "多吃鱼，建议每周吃2-3次鱼，如鲫鱼、草鱼、大头鱼等；严格禁止饮酒、吸烟。"
            ];
        }else if($stateParams.id==3){
            $scope.title="高尿酸血症与痛风饮食指导";
            $scope.imglist=['zhidao/img/14.jpg','zhidao/img/15.jpg','zhidao/img/16.jpg'];
            $scope.content=[
                "限制膳食嘌呤。建议不食含嘌呤高的食物，如虾、蟹、海鲜、动物内脏、浓鸡汤、火锅汤、肉汤等。可适量进食嘌呤含量少的食物，如粗粮、杂豆、鸡肉、火腿、草鱼、芦笋、海带、菠菜等。可多食嘌呤含量很少的食物，如薯类、鸡蛋、牛奶、姜、葱、蒜、木耳、水果等。",
                "多吃新鲜的蔬菜、水果和奶类；多喝水，每天饮水2000ml以上，可喝白开水、淡茶水等，不喝汽水、咖啡、浓茶等。",
                "避免饮酒及酒精饮料，如啤酒、白酒、葡萄酒等。"
            ]
        }else if($stateParams.id==4){
            $scope.title="实用日常饮食指导";
            $scope.imglist=['zhidao/img/1.jpg','zhidao/img/2.jpg','zhidao/img/3.jpg','zhidao/img/4.jpg'];
            $scope.content=[
                "食物应多种多样，避免品种单一，保证营养充足；每天吃粗杂粮，如全麦、玉米、小米、荞麦和燕麦等。",
                "每天食用奶和奶制品，如牛奶，酸奶等，有利于预防骨质疏松症和骨折；常吃大豆及豆制品，如豆腐，豆浆等。",
                "建议食用脂肪含量较低的禽肉和鱼类，少吃饱和脂肪酸和胆固醇含量高的畜肉；多吃新鲜的时令蔬菜和水果。",
                "饮食清淡，少吃各种酱料、盐腌食物、肥肉、油炸食品、甜点以及动物内脏等；白天多喝白开水，也可泡一些花草茶，少喝浓茶、含糖饮料。"
            ];
        }
        $scope.close=function(){
            clearInterval($scope.timer);//ztb
        }
        $(function() {
            var arr=$scope.content;
            var vcon = $(".v_cont ");
            var len=vcon.find("li").length;
            var $spanActive=$(".circle-num .active");
            var $spanAll=$(".circle-num .all");
            var $pTxt=$(".circle-cur .txt");


            $pTxt.text(arr[0]);
            $(".txt").removeClass("showP");
            //自动轮播
            if($scope.timer){
                clearInterval($scope.timer);
            }
            $scope.timer=setInterval(function(){
                nextscroll();
            },3000);//ztb

            $(".next a").click(function() {
                if($scope.timer){
                    clearInterval($scope.timer);//ztb
                    nextscroll();
                    $scope.timer=setInterval(function(){//ztb
                        nextscroll();
                    },3000);
                }
            });
            $spanAll.html(len);
            function nextscroll() {
                var offset = ($(".v_cont li").width()) * -1;
                vcon.stop().animate({
                    left: offset
                }, "slow", function() {
                    var firstItem = $(".v_cont ul li").first();
                    vcon.find("ul").append(firstItem);
                    $(this).css("left", "0px");
                    circle();
                })
            };

            var showOff=false;
            function circle() {
                var currentItem = $(".v_cont ul li").first();
                var currentIndex = currentItem.attr("index");
                $spanActive.text(parseInt(currentIndex)+1);
                $pTxt.text(arr[currentIndex]);

            }
            $(".prev a").click(function() {
                if($scope.timer){
                    clearInterval($scope.timer);
                    var vcon = $(".v_cont ");
                    var offset = ($(".v_cont li").width() * -1);
                    var lastItem = $(".v_cont ul li").last();
                    vcon.find("ul").prepend(lastItem);
                    vcon.css("left", offset);
                    vcon.stop().animate({
                        left: "0px"
                    }, "slow", function() {
                        circle();
                    });

                    $scope.timer=setInterval(function(){
                        nextscroll();
                    },3000);
                }

            });

            $(".circle-cur .show-btn").click(function(){
                $(this).parent().prev("p").toggleClass("showP");
            })
        })
    }])
    /*--------------- 指导详情----------------*/
    .controller('zhucanCtrl', ['$scope',"$stateParams", function ($scope,$stateParams) {
        if($stateParams.id==1){
            $scope.title="南村镇敬老院配餐中心";
            $scope.imglist=['gaikuang/img/jinglao.jpg','gaikuang/img/jinglao2.jpg','gaikuang/img/jinglao3.jpg'];
            $scope.content=["南村镇敬老院是南村镇人民政府发展社会福利事业，加快社会保障制度改革而规划兴建的，它是弘扬中华民族敬老、爱老、养老的传统美德，为老人颐养天年而设立的社会福利服务机构。我院开办于1994年12月，2003年扩建，院区占地面积9500平方米，建筑基底面积6500平方米，户外绿化和休闲公园3000平方米。",
                "建有老人住宿楼6幢、办公楼1幢、多功能中心1幢，共99个套间，170个床位，设有文娱室、健身室、医疗室、居家养老服务部、星光老人活动中心、日间托老中心。2003年12月被评为广东省一级敬老院。",
                " 敬老院得到各级领导的重视和支持，每年都在原有配套上增加和完善院内的软硬件设施，使我院的院容院貌焕然一新。在服务方面我院进一步改进工作方法，提高服务质量，让入住老人生活舒心，入住安心，娱乐开心，在我院安度晚年。"];
        }else if($stateParams.id==2){
            $scope.title="南村社区助餐点";
            $scope.imglist=['gaikuang/img/nancun.jpg','gaikuang/img/nancun2.jpg'];
            $scope.content=[
                "南村社区位于广州市番禺区南村镇新公路北段1012号南山公园内东侧，其管辖的人口遍布16条自然行政村，10个楼盘小区，现时的管辖范围面积47000平方公里，户籍人口5578人，外来人口6987人。",
                "60岁以上老人1103人，占比19.7%，70岁以上老人514人，90岁以上老人25人；独居老人20人，留守老人15人，空巢老人12人，失能人数25人，“五保”和“低保”共6人。"];
        }else if($stateParams.id==3){
            $scope.title="永大社区助餐点";
            $scope.imglist=['gaikuang/img/yongda.png','gaikuang/img/yongda2.jpg'];
            $scope.content=[
                "永大社区位于广州市番禺区南村镇市新路段，原为广州市永大集团公司，属企业型社区，原占地面积1.76平方公里，现占地面积44.3万平方米。1995年转制后，全体职工实行社会化管理。现社区共有居民楼76座，现社区常住人口3318人,其中户籍人口1783人，外来人口1535人。",
                "60岁以上老人688人，70岁以上老人426人，80岁以上老人172人，90岁以上老人16人。独居老人29人，留守老人533人，空巢老人98人，失能老人11人，“低保”6人。"]
        }
        /*关闭时顺便关闭定时器*/
        $scope.close=function(){
            clearInterval($scope.timer);//ztb
        }

        $(function() {
            var arr=$scope.content;
            var vcon = $(".v_cont ");
            var len=vcon.find("li").length;
            var $spanActive=$(".circle-num .active");
            var $spanAll=$(".circle-num .all");
            var $pTxt=$(".circle-cur .txt");

            $pTxt.text(arr[0]);
            $(".txt").removeClass("showP");

            if($scope.timer){
                clearInterval($scope.timer);
            }
            $scope.timer=setInterval(function(){
                nextscroll();
            },3000);//ztb
            $(".next a").click(function() {
                if($scope.timer){
                    clearInterval($scope.timer);//ztb
                    nextscroll();
                    $scope.timer=setInterval(function(){//ztb
                        nextscroll();
                    },3000);
                }
            });
            $spanAll.html(len);
            function nextscroll() {
                var offset = ($(".v_cont li").width()) * -1;
                vcon.stop().animate({
                    left: offset
                }, "slow", function() {
                    var firstItem = $(".v_cont ul li").first();
                    vcon.find("ul").append(firstItem);
                    $(this).css("left", "0px");
                    circle();
                })
            };

            var showOff=false;
            function circle() {
                var currentItem = $(".v_cont ul li").first();
                var currentIndex = currentItem.attr("index");
                $spanActive.text(parseInt(currentIndex)+1);
                $pTxt.text(arr[currentIndex]);

            }
            $(".prev a").click(function() {
                if($scope.timer){
                    clearInterval($scope.timer);

                    var vcon = $(".v_cont ");
                    var offset = ($(".v_cont li").width() * -1);
                    var lastItem = $(".v_cont ul li").last();
                    vcon.find("ul").prepend(lastItem);
                    vcon.css("left", offset);
                    vcon.animate({
                        left: "0px"
                    }, "slow", function() {
                        circle();
                    });

                    $scope.timer=setInterval(function(){
                        nextscroll();
                    },3000);
                }

            });

            $(".circle-cur .show-btn").click(function(){
                $(this).parent().prev("p").toggleClass("showP");
            });
        });
    }])
    /*--------------- 管理页面----------------*/
    .controller('manageLoginCtrl', ['$scope',"$state", "$http","$cookies",function ($scope,$state,$http,$cookies) {
        if($cookies.get("managePass")){
            $scope.phNumber=$cookies.get("managePass");
            $scope.imgurl="../images/true.png";
            $scope.flag=true;
        }else{
            $scope.imgurl="../images/false.png";
            $scope.flag=false;
        }
        $scope.sure=function(){
            if($scope.phNumber){
                $http.get("../../app/verificationUser",{
                    params:{
                        password:$scope.phNumber
                    }
                }).then(function(response){
                    if(response.data){
                        $scope.alText="登录成功";
                        if($scope.flag){
                            $cookies.put("managePass",$scope.phNumber);
                        }
                        $state.go("manageFeature");
                    }else{
                        $scope.alText="输入错误，请校正登录！";
                    }

                }).catch(function(error){
                    console.log(error);
                });
            }else{
                $scope.alText="请输入密码，再登录！";
            }
        }
        /*记住密码的默认图片地址*/
        $scope.remember=function(){
            if($scope.flag==false){
                $scope.imgurl="../images/true.png";
                $scope.flag=true;
            }else{
                $scope.imgurl="../images/false.png";
                $scope.flag=false;
                $cookies.remove("managePass");
            }
        }
    }])
    /*--------------- 管理功能----------------*/
    .controller('manageCtrl', ['$scope',"$http","$cookies","$state",function ($scope,$http,$cookies,$state) {
        $scope.teamName=$cookies.get("teamName");
        /*start点餐*/
        $scope.mask_password=false;
        //退出回话

        //移除回话
        $http.get("../../app/orderAntiVerification").then(function(response){
        }).catch(function(error){
            console.log(error);
        });
        //操作员验证退出点餐权限
        $scope.operatorPermission=function(){
            $http.get("../../app/queryOpeatorSession").then(function(response){
                if(response.data){
                    //会话验证为true直接进入用户列表
                    $state.go("useDetail");
                }else{
                    $scope.mask_password=true;
                    $scope.manage_alert='';
                    $scope.manage_password='';
                }
            }).catch(function(error){
                console.log(error);
            });
        }
        //管理员验证,点餐时验证操作员
        $scope.manage=function(){
            if($scope.manage_password){
                $http.get("../../app/orderVerificationUser",{params:{password:$scope.manage_password}}).then(function(response){
                    if(response.data){
                        $scope.manage_alert="登录成功！";
                        $state.go("useDetail");
                    }else{
                        $scope.manage_alert="密码错误，请校正登录！";
                    }
                }).catch(function(error){
                    console.log(error);
                });
            }else{
                $scope.manage_alert="请输入密码，再登录！";
            }
        }
        //按取消清除回话
        $scope.quit=function(){
            $http.get("../../app/orderAntiVerification").then(function(response){
            }).catch(function(error){
                console.log(error);
            });
        }
        /*end*/

        /*start查询*/
        /*助餐点start*/
        $("#mask").css("display","none");
        $scope.flag=null;//保存跳转的地址
        $scope.alert=function(target){
            //判断之前有无输过密码
            $http.get("../../app/queryOpeatorSession").then(function(response){
                if(response.data){
                    //会话验证为true直接进入
                    $state.go(target);
                }else{
                    $("#mask").css("display","block");
                    $("#input").val("");
                    $("#false-alert").css("visibility","hidden");
                    $scope.flag=target;
                }
            }).catch(function(error){
                console.log(error);
            });
        }
        $("#quxiao").click(function(){
            $("#mask").css("display","none");
        });
        $scope.queding=function(){
                if($("#input").val()){
                    $http.get("../../app/verificationUser",{params:{
                        password:$("#input").val()
                    }}).then(function(response){
                        if(response.data){
                            $state.go($scope.flag);
                        }else{
                            $("#false-alert").html("密码错误，请校正登录！");
                            $("#false-alert").css("visibility","visible");
                        }
                    }).catch(function(error){
                        console.log("失败");
                    });
                }else{
                    $("#false-alert").html("请输入密码，再登录！");
                    $("#false-alert").css("visibility","visible");
                }
        }
        /*end*/

        /*订单情况*/
        $http.get("../../app/statisticsOrder", {
                params:
                {"teamId": $cookies.get("teamId")}
            }
        ).then(function (result) {
                $scope.json=JSON.stringify([{"y":result.data.dayCount,"color":"#f5c33b"},
                    {"y":result.data.weekCount,"color":"#f89d1a"},
                    {"y":result.data.monthCount,"color":"#eea966"}]);
                /*订单情况*/
                var json=$scope.json;
                Highcharts.chart('dingcqk', {
                    credits:{
                        enabled:false
                    },
                    chart: {
                        type: 'column'
                    },
                    legend:{
                        enabled: false,
                        title: {
                            text: ''
                        }
                    },
                    tooltip:{
                        enabled:false
                    },
                    title: {
                        text: '订单情况',
                        style:{ "color": "#575757", "fontSize": "30px" }
                    },
                    yAxis: {
                        gridLineWidth: 0,
                        lineWidth:1,
                        title:{
                            text:""
                        },
                        labels:{
                            enabled:false
                        }
                    },
                    responsive: {
                        rules: [{
                            condition: {
                                maxWidth: 447,
                                maxHeight:339
                            },
                            chartOptions:{
                                legend:{
                                    enabled:false
                                }
                            }
                        }
                        ]},
                    xAxis: {
                        labels: {
                            y: 30, //x轴刻度往下移动20px
                            style: {
                                fontSize:'0.20rem', //字体
                                lineHeight:'0.6rem'
                            }
                        },
                        categories: ['当天订餐', '本周订餐', '本月订餐'],
                        lineWidth:2,
                        lineColor:"#dedede",
                        title:{text:""}
                    },
                    plotOptions: {
                        series: {
                            colorByPoint: false,
                            dataLabels: {
                                align: 'center',
                                enabled: true,
                                rotation:360,
                                x: 0,
                                y: -10,
                                style : {
                                    'fontSize' : '0.25rem',
                                    fontWeight:'normal'
                                }
                            }
                        }
                    },
                    series:[{
                        data:eval(json)
                    }]
                });
            }).catch(function (result) {
                console.log("失败");
            });
        /*助餐对象*/
        $http.get("../../app/statisticsSubject", {
                params:
                {"teamId": $cookies.get("teamId")}
            }
        ).then(function (result) {
                $scope.json2=JSON.stringify([{"y":result.data.newInWeekCount,"color":"#f5c33b"},
                    {"y":result.data.list[0].count,"color":"#f89d1a"},
                    {"y":result.data.list[1].count,"color":"#eea966"},
                    {"y":result.data.list[2].count,"color":"#d49885"},
                    {"y":result.data.count,"color":"#f56042"}
                ]);
                /*助餐对象*/
                var json2=$scope.json2;
                Highcharts.chart('zhucdx', {
                    credits:{
                        enabled:false
                    },
                    legend:{
                        enabled: false,
                        title: {
                            text: ''
                        }
                    },
                    chart: {
                        type: 'column'
                    },
                    tooltip:{
                        enabled:false
                    },
                    title: {
                        text: '助餐对象',
                        style:{ "color": "#575757", "fontSize": "30px" }
                    },
                    yAxis: {
                        gridLineWidth: 0,
                        lineWidth:1,
                        title:{
                            text:""
                        },
                        labels:{
                            enabled:false
                        }
                    },
                    responsive: {
                        rules: [{
                            condition: {
                                maxWidth: 447,
                                maxHeight:339
                            },
                            chartOptions:{
                                legend:{
                                    enabled:false
                                }
                            }
                        }]},
                    xAxis: {
                        labels: {
                            y: 30, //x轴刻度往下移动20px
                            style: {
                                fontSize:'0.2rem', //字体
                                lineHeight:'0.6rem'
                            }
                        },
                        categories: ['本月新增对象', '全额补贴', '部分补贴',"自费","总计"],
                        lineWidth:2,
                        lineColor:"#dedede",
                        title:{enabled:false}
                    },

                    plotOptions: {
                        series: {
                            colorByPoint: false,
                            dataLabels: {
                                align: 'center',
                                enabled: true,
                                rotation:360,
                                x: 0,
                                y: -10,
                                style : {
                                    fontSize: '0.25rem',
                                    fontWeight:'normal'
                                }
                            }
                        }
                    },
                    series: [{
                        data:eval(json2)
                    }]
                });
            }).catch(function (result) { //捕捉错误处理
                console.log("失败");
            });
    }])
    /*--------------- 管理发放功能----------------*/
    .controller('mDeliveryCtrl', ['$scope',"$cookies","$http", function ($scope,$cookies,$http) {
        //查找助餐点下可进行发放的订单
        $http.get("../../app/findForTransmission",{
            params:{
                data:getNowFormatDate(),        /*页面传递的日期*/
                mealTypeId:"0",
                teamId:$cookies.get("teamId")
            }
        }).then(function(response){
            $scope.list=response.data;
            $scope.btns=[];
            for(var i=0;i<$scope.list.length;i++){
                $scope.btns[i]={};
                $scope.btns[i].id=$scope.list[i].id;
            }

        }).catch(function(error){
            console.log(error);
        });
        //查找餐别接口
        $http.get("../../app/findAllMealType").then(function(response){
            $scope.company=response.data;
            $scope.company.unshift({id:0,mealTypeName:"所有"});
        }).catch(function(error){
            console.log(error);
        });
        /*获取当前时间函数*/
        function getNowFormatDate() {
            var date = new Date();
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if(month >= 1 && month <= 9) {
                month ="0" + month;
            }
            if(strDate >= 0 && strDate <= 9) {
                strDate ="0" + strDate;
            }
            var currentdate = date.getFullYear() + "-" + month + "-" + strDate;
            return currentdate;
        }
        /*日期选择*/
        $("#selectTime").jeDate({
            isinitVal:true,
            isClear:false,
            ishmsVal:true,
            trigger:"click",
            minDate: '2016-06-16',
            format:"YYYY-MM-DD",
            zIndex:3000,
            choosefun: function(elem,datas,val){
                $scope.time=val.substr(0,10);
            },
            success:function(elem,date) {
            }
        });
        $scope.myFunc=function(){
            console.log($scope.selected);
        }
        /*查询*/
        $scope.time=$scope.time?$scope.time:getNowFormatDate();
        $scope.search=function(){
            $http.get("../../app/findForTransmission",{
                params:{
                    teamId:$cookies.get("teamId"),
                    mealTypeId:$scope.selected,     /*选择的配送单id*/
                    data:$scope.time
                }
            }).then(function(response){
                $scope.list=response.data;
            }).catch(function(error){
                console.log(error);
            });
        }
        /*全选按钮*/
        $scope.checked = [];
        $scope.selectAll=function(){
            if($scope.select_all) {
                $scope.checked = [];
                angular.forEach($scope.btns, function (i) {
                    i.checked = true;
                    $scope.checked.push(i.id);
                })
            }else {
                angular.forEach($scope.btns, function (i) {
                    i.checked = false;
                    $scope.checked = [];
                })
            }
        }
        /*单选*/
        $scope.selectOne = function () {
            angular.forEach($scope.btns,function (i) {
                var index = $scope.checked.indexOf(i.id);
                if(i.checked && index === -1) {
                    $scope.checked.push(i.id);
                } else if (!i.checked && index !== -1){
                    $scope.checked.splice(index, 1);
                }
            });

            if($scope.btns.length === $scope.checked.length) {
                $scope.select_all = true;
            } else {
                $scope.select_all = false;
            }
        }
        /*确认发放和批量发放*/
        $scope.delivery=function(id,$event){
         /*选择的配送单id*/
            if(id=="all"){
                if($scope.checked.length!=0){
                    $http({
                        method: 'POST',
                        url: '../../app/transmissionOrder',
                        data:{
                            teamId:$cookies.get("teamId"),
                            list:$scope.checked
                        }
                    }).then(function successCallback(response) {
                        var buttonDoms=$("#tbody tr .ng-not-empty").parent().parent().parent().find('button');
                        buttonDoms.addClass("active");
                        buttonDoms.html("已发放");
                        buttonDoms.parent().prev().html("已发放");
                    }, function errorCallback(response) {
                        // 请求失败执行代码
                        console.log(response);
                    });
                }
            }else{
                $http({
                    method: 'POST',
                    url: '../../app/transmissionOrder',
                    data:{
                        teamId:$cookies.get("teamId"),
                        list:[id]
                    }
                }).then(function successCallback(response) {
                    $($event.target).addClass("active");
                    $($event.target).html("已发放");
                    $($event.target).parent().prev().html("已发放");
                }, function errorCallback(response) {
                    // 请求失败执行代码
                    console.log(response);
                });
            }

        }
    }])
    /*--------------- 管理送达功能----------------*/
    .controller('mSendCtrl', ['$scope',"$cookies","$http" ,function ($scope,$cookies,$http) {
        //查询配送单
        $http.get("../../app/findHnxftDeliveNote",{
            params:{
                teamId:$cookies.get("teamId"),
                state:"已配送"
            }
        }).then(function(response){
            $scope.list=response.data;
        }).catch(function(error){
            console.log(error);
        });
        /*日期*/
        $("#selectTime").val(getNowFormatDate());
        function getNowFormatDate() {
            var date = new Date();
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if(month >= 1 && month <= 9) {
                month ="0" + month;
            }
            if(strDate >= 0 && strDate <= 9) {
                strDate ="0" + strDate;
            }
            var currentdate = date.getFullYear() + "-" + month + "-" + strDate;
            return currentdate;
        }
        $scope.myFunc=function(){
                console.log($scope.selected);
        }
        /*查询*/
        $scope.selected=$scope.selected?$scope.selected:"已配送";
        $scope.search=function(){
            $http.get("../../app/findHnxftDeliveNote",{
                params:{
                    teamId:$cookies.get("teamId"),
                    state:$scope.selected /*选择的配送单id*/
                }
            }).then(function(response){
                $scope.list=response.data;
            }).catch(function(error){
                console.log(error);
            });
        }
        /*确认送达*/
        $scope.send=function($event,id){
            if($($event.target).hasClass('null')){
                $http.get("../../app/confirmDeliveNote",{
                    params:{
                        teamId:$cookies.get("teamId"),
                        deliveId:id /*选择的配送单id*/
                    }
                }).then(function(response){
                    $($event.target).addClass("active");
                    $($event.target).html("已送达");
                    $($event.target).parent().prev().html("已送达");
                }).catch(function(error){
                    console.log(error);
                });
            }
        }
        /*查看明细*/
        $scope.detail=function(id){
            $scope.maskshow=true;
            $http({
                method: 'GET',
                url: '../../app/findHnxtDeliveDetai',
                params:{
                    deliveId:id
                }
            }).then(function successCallback(response) {
                $scope.listDetail=response.data;
            }, function errorCallback(response) {
                // 请求失败执行代码
                console.log(response);
            });
        }
    }])
;

