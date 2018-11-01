<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Size가 변경될 Layout은 row 일 경우 row-columnId,col 일 경우 col-columnId 로 규칙 정의 -->
<div class="panel-body sortableLayout gridLayoutArea">
	<div class="row"  style="height: 50%;" id="row-column-4">
		<div class="col-md-12 col sub-col" style="height: 100%;width: 50%;" id="col-column-4">
			<ul class="sortable-list ui-sortable list-group" id="column-4" data-init-area="input">
			</ul>
		</div>
		<div class="devider vertical" id="devider-1" data-equal-id="col-column-4" data-remainder-id="col-column-5" set-equal-ids="column-4" set-remainder-ids="column-5"></div>
		<div class="col-md-12 col sub-col" style="height: 100%;width: 50%;" id="col-column-5">
			<ul class="sortable-list ui-sortable list-group" id="column-5" data-init-area="log">
			</ul>
		</div>
	</div>
	<div class="devider horizontal" id="devider-2" data-equal-id="row-column-4" data-remainder-id="row-column-6" set-equal-ids="column-4|column-5" set-remainder-ids="column-6"></div>
	<div class="row"  style="height: 50%;" id="row-column-6">
		<div class="col-md-12 col sub-col" style="height: 100%;">
			<ul class="sortable-list ui-sortable list-group" id="column-6" data-init-area="output">
			</ul>
		</div>
	</div>
</div>