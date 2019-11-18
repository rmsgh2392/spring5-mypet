"use strict"
var app = app || {}
app = (()=>{
	let _,js
	let init=()=>{
		_ = $.ctx()
		js = $.js()
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
	}
	return {run}
})()