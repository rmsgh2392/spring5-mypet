"use strict"
var app = app || {}
app = (()=>{
	let _,js,css,img
	let init=()=>{
		_ = $.ctx()
		js = $.js()
		css = $.css()
		img = $.img()
		alert('ctx:'+_)
	}
	let run =x=>{
		$.getScript(x+'/resources/js/cmm/router.js',()=>{
			$.extend(new Session(x))
			onCreate()
		})
	}
	let onCreate =()=>{
		init()
		alert('박근호')
		setContentView()
	}
	let setContentView =()=>{
		$('<table><tr></tr></table>',{
			id : 'tab'
		})
		.css({width:'100%',height :'1000px',border:'1px solid black', margin:'auto', 'border-collapse' : 'collapse','background-image':'url('+img+'/mini.jpg)','background-repeat': 'repeat'})
		.appendTo('body')
		$('<td/>',{id: 'left'}).css({width:'20%',height:'100%',border:'1px solid black','vertical-align':'top'}).appendTo('tr')
		$('<td/>',{id: 'right'}).css({width:'80%',height:'100%',border:'1px solid black','vertical-align':'top'}).appendTo('tr')
		let arr =[{txt: '벅스뮤직차트',name : 'bugs_crawl'},
				  {txt: 'cgv영화차트',name : 'cgv_crawl'},
				  {txt: 'naver오늘의단어' ,name:'naver_crwal'},
				  {txt: '구글애견음식점',name:'google_crawl'}]
		$.each(arr,(i,j)=>{
			$('<div/>')
			.text(j.txt)
			.css({width : '100%',
				  height:'50px',
				  border:'1px solid green',
				  'background-color' : 'lavender',
				  color : 'black',
				 'text-align' : 'center',
				 'font-size': 'xx-large'})
			.appendTo('#left')
			.click(function(){
				$(this).css({'background-color':'yellow'})
				$(this).siblings().css({'background-color':'white'})
				switch($(this).text()){
				case '벅스뮤직차트':
					bugs_crawl({img : $.img()})
					break;
				case 'cgv영화차트':
					cgv_crawl()
					break;
				case 'naver오늘의단어':
					naver_crwal()
					break;
				case '구글애견음식점':
					google_crawl()
					break;
			}
	})
			
})
		
		
	}
	let bugs_crawl =()=>{
		alert('벅스 크롤링 ㄱㄱ')
		$('#right').empty()
		$.getJSON(_+'/crawls/bugs',d=>{
			$.each(d,(i,j)=>{
			$('<tr/>',{
					id : 'id_'+i+'',
					
				}).html('<img src="'+j.photo+'">'+j.title)
				.css({width:'40%',height:'40%',border: '1px solid orange'}).appendTo('#right')
				$('<td/>',{
					text : j.artist
				}).css({width:'70%'}).appendTo('tr#id_'+i+'')
			})
		})
	}
	let cgv_crawl=()=>{
		alert('cgv차트 ㄱㄱ')
		$('#right').empty()
		$.getJSON(_+'/crawls/cgvs',d=>{
			$.each(d,(i,j)=>{
				$('<td/>').css({
					'background-color': 'black',
//					display : 'inline-flex',
			    	color: 'navajowhite',
					width : '30%',
				   'text-align' : 'center',
					border:'2px solid lavender',
					float:'left'}).html('<img src="'+j.photo+'"><br/>'+'<h4>'+j.title+'</h4><br/>'+'<br/>'+j.content+'<br/>').appendTo('#right')
			})
		})
	}
	let naver_crwal =()=>{
		alert('네이버 ㄱㄱ')
		$('#right').empty()
		$.getJSON(_+'/crawls/naver',d=>{
			//d에 전달된 값 list면 each룹에  j값으로 바로 전달 가능
			//but map이면 d.키값 이렇게 매칭시켜 써준다
			alert('d.size :'+d.length)
			$.each(d,(i,j)=>{
//				$('<tr/>',{//<tr/> -- > <td></td>의 약어  고스트면 무조건 어팬트 투 해서 내가 붙히고 싶은 화면에 붙힌다.
//					id : 'id_'+i+'',
//					text : j.origin
//				}).appendTo('#right')
	/*			$('<td/>',{
					text : j.trans
				}).css({'background-color': 'black',
			    color: 'wheat'}).appendTo('tr#id_'+i+'')*/
				
			    $('<td/>')
					//글자만 text만 주고 싶을땐 .text() 하면 되고 내가 여기다 <h1>태그를 주고 싶다 --> .html()
				.css({width:'40%',
					height:'40%',
					border:'2px solid tomato',
					float:'left'}).html('<h1>'+j.origin+'<h1>'+'<h4>'+j.trans+'<h4>').appendTo('#right')
		})
	})
		
	}
	return {run}
})()