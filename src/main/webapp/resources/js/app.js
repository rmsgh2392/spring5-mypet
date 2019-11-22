"use strict"
var app = app || {}
app = (()=>{
	let _,js,css,img,pop_js
	let init=()=>{
		_ = $.ctx()
		js = $.js()
		css = $.css()
		img = $.img()
		pop_js = js+'/pop.js'
		alert('ctx:'+_)
	}
	let run =x=>{
		$.when(
			$.getScript(x+'/resources/js/cmm/router.js',()=>{$.extend(new Session(x))}),
			$.getScript(pop_js)
		)
		.done(()=>{
			onCreate()
		})
		.fail(()=>{alert('getScript 실패 ')})
	}
	let onCreate =()=>{
		init()
		$(pop.view({img : $.img()})).appendTo('body')
		pop.open()
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
				  {txt: 'naver오늘의단어',name: 'naver_crwal'},
				  {txt: '멜론차트',name: 'melon_crawl'}]
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
					bugs_crawl(0)
					break;
				case 'cgv영화차트':
					cgv_crawl()
					break;
				case 'naver오늘의단어':
					naver_crwal()
					break;
				case '멜론차트':
					melon_crawl()
					break;
			}
	})
			
})
		
		
	}
	let bugs_crawl =x=>{
		alert('벅스 크롤링 ㄱㄱ')
		$('#right').empty()
		$.getJSON(_+'/crawls/bugs/page/'+x+'',d=>{
			let page = d.pagination
			let data = d.list
			alert('page :'+page.startPage + page.endPage)
/*			$('<table id="content"><tr id="header"></tr></table>')
			.css({}).appendTo('#right')
			$.each(['사진','가수','제목'],(i,j)=>{
				$('<th/>').html('<b>'+j+'</b>').css({width :'99%',height : '50px',border: '1px solid black'}).appendTo('#header')
			})
			$.each(data,(i,j)=>{
				$('<tr><td>'+j.bugsseq+'</td><img src="'+j.photo+'"/><td>'+j.photo+'</td><td>'+j.artist+'</td><td>'+j.title+'</td></tr>')
				.css({width : '25%',height:'100%',border:'1px solid black'})
				.appendTo('#content tbody')
			})
			$('#content tr td').css({border : '1px solid tomato'})
			$.each([],(i,j)=>{
				$('<div/>').css({width : '80px',height : '80px'})
				.appendTo('#right')
			})*/
			$('<table id="content"><thead><tbody></tbody></thead></table>').css({width : '100%',border : '1px solid lavender','border-collapse' : 'collapse'}).appendTo('#right')
			$.each(['순위','제목','artist'],(i,j)=>{
				$('<th/>').text(j).css({width : '25%',height:'50px'}).appendTo('#content thead')
			})
			$.each(data,(i,j)=>{
				$('<tr><td>'+j.bugsseq+'</td><td><img src="'+j.photo+'"></td><td>'+j.artist+'</td><td>'+j.title+'</td></tr>')
				.css({'background-color': 'lavender',
			    	  'vertical-align': 'top',
			    	  border : '1px solid lightblue'
						})
				.appendTo('#content tbody')
			})
			$('<div/>',{id : 'pagination'})
			.css({width : '50%',
				  height : '50px',
				  margin: '50px auto'
				  })
			.appendTo('#right')
			if(page.existPrev){
				$('<span/>')
				.css({display : 'inline-block',width : '70px',height : '50px',border: '3px solid lavender' ,'background-image':'url('+img+'/mini.jpg)','text-align': 'center','padding-top': '5%','background-size': 'cover','font-size': 'xx-large'})
				.text('잘가')
				.prependTo('#pagination')
				.click(()=>{
					bugs_crawl(page.prevBlock)
				})
			}
			let i = page.startPage
			for(;i<=page.endPage;i++){
				$('<span/>')
				.css({display : 'inline-block',width : '70px',height : '50px',border: '3px solid hotpink' ,'background-image':'url('+img+'/mini.jpg)','text-align': 'center','padding-top': '5%','background-size': 'cover','font-size': 'xx-large'})
				.text(i+1)
				.appendTo('#pagination')
				.click(function(){
					let p = parseInt($(this).text())
					alert('현재 클릭한 페이지 번호 :'+(p - 1))
					bugs_crawl(p-1)
				})
			}
			if(page.existNext){
				$('<span/>')
				.css({display : 'inline-block',width : '70px',height : '50px',border: '3px solid lavender' ,'background-image':'url('+img+'/mini.jpg)','text-align': 'center','padding-top': '5%','background-size': 'cover','font-size': 'xx-large'})
				.text('꺼져')
				.appendTo('#pagination')
				.click(()=>{
					bugs_crawl(page.nextBlock)
				})
			}
			/*for(i=page.startPage;i<=page.endPage;i++){
				if(page.currPage == i){
				$('<div id="paging" style="float : left;"><span class="sp" style="font-size : 50px; border : groove;">'+(i+1)+'</span></div>')
					.appendTo('#right')
				}else{
					$('<div id="paging" style="float : left;"><span class="sp" style="font-size : 50px; border : groove;">'+(i+1)+'</span></div>')
					.appendTo('#right')
					.click(function(){
						alert('페이지 번호  : '+$(this).children('.sp').text())
						bugs_crawl({page : $(this).children('.sp').text()})
					})
				}
				
			}*/
		})
	}
	let cgv_crawl=()=>{
		alert('cgv차트 ㄱㄱ')
		$('#right').empty()
		$.getJSON(_+'/crawls/cgvs',d=>{
			$.each(d,(i,j)=>{
				$('<td/>').css({
					'background-color': 'black',
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
			$.each(d,(i,j)=>{
//				<td></td>의 약어  고스트면 무조건 어팬트 투 해서 내가 붙히고 싶은 화면에 붙힌다.				
//				글자만 text만 주고 싶을땐 .text() 하면 되고 내가 여기다 <h1>태그를 주고 싶다 --> .html()
			    $('<td/>')
				.css({width:'40%',
					height:'40%',
					border:'2px solid tomato',
					float:'left'}).html('<h1>'+j.origin+'<h1>'+'<h4>'+j.trans+'<h4>').appendTo('#right')
		})
	})
		
	}
	let melon_crawl =()=>{
		alert('멜론차트 ㄱㄱ')
		$('#right').empty()
		$.getJSON(_+'/crawls/melon',d=>{
			$.each(d,(i,j)=>{
				$('<tr><td>'+j.ranking+'<img src="'+j.photo+'"></td><td>'+j.content+'</td><td>'+j.allbum+'</td></tr>')
				.css({border:'2px solid lavender'})
				.appendTo('#right')
			})
		})
	}
	return {run, bugs_crawl}
})()
/*			$.each(data,(i,j)=>{
			$('<tr/>',{
					id : 'id_'+i+'',
				}).html('<td>'+j.bugsseq+'</td><img src="'+j.photo+'">'+j.title)
				.css({width:'10%',height:'40%',border: '1px solid orange'}).appendTo('#content tbody')
				$('<td/>',{
					text : j.artist
				}).css({width:'70%'}).appendTo('tr#id_'+i+'')
			})*/