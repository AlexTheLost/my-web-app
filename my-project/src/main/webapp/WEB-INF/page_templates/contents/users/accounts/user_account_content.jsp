<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">

    <div class="row pull" style="width: 30%;">
        <a href="user_account_setting">Editing user</a>
        
        <div class="col-md-12" style="margin: 20px 0px 20px;">
            <label class="form-label"><b><i class="icon-user icon-3x"></i>&nbsp;${name}</b></label>
        </div>

        <div class="col-md-12" style="margin: 20px 0px 20px;">
            <p>Avatar:</p>
            <img src="https://app.divshot.com/img/placeholder-100x100.gif">
        </div>

        <div class="col-md-12" style="margin: 20px 0px 20px;">
            <label class="form-label">Email: ${email}</label>
        </div>

        <div class="col-md-12" style="margin: 20px 0px 20px;">
            <label class="form-label">Language: ${language}</label>
        </div>

        <div class="col-md-12" style="margin: 20px 0px 20px;">
            <label class="form-label">Stile: ${stile}</label>
        </div>

        <div class="col-md-12" style="margin: 20px 0px 20px;">
            <label class="form-label">ShortDescription: ${shortDescription}</label>
        </div>

    </div>
</div>