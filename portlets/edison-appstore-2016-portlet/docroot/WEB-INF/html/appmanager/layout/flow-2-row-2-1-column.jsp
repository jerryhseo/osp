<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="panel-body sortableLayout gridLayoutArea">
	<div class="row" style="display: none;">
		<div class="col-md-6 col">
			<ul class="sortable-list ui-sortable list-group" id="column-4" data-init-area="input">
			</ul>
		</div>
		<div class="col-md-6 col">
			<ul class="sortable-list ui-sortable list-group" id="column-5" data-init-area="log">
			</ul>
		</div>
	</div>
	<div class="row" style="height:100%">
		<div class="col-md-12"  style="height:100%;width:50%;" id="col-column-6">
			<div class="row" style="height:50%" id="row-column-6">
				<div class="col-md-12 col sub-col" style="height:100%">
					<ul class="sortable-list ui-sortable list-group" id="column-6">
						
					</ul>
				</div>  
			</div>
			<div class="devider horizontal" data-equal-id="row-column-6" data-remainder-id="row-column-7" set-equal-ids="column-6" set-remainder-ids="column-7"></div>
			<div class="row" style="height:50%" id="row-column-7">
				<div class="col-md-12 col sub-col"style="height:100%">
					<ul class="sortable-list ui-sortable list-group" id="column-7">
					
					</ul>
				</div>
			</div>
		</div>
		<div class="devider vertical" data-equal-id="col-column-6" data-remainder-id="col-column-8" set-equal-ids="column-6|column-7" set-remainder-ids="column-8"></div>
		<div class="col-md-12 col"  style="height:100%;width:50%;" id="col-column-8">
			<ul class="sortable-list ui-sortable list-group" id="column-8" data-init-area="output" style="height:100%">
			</ul>
		</div>
	</div>
</div>