<div class="hold-transition skin-black-light sidebar-mini" id="body-div">
	<header class="main-header" id="${namespace}${layoutKey}column-2" section-type="system">
		
	</header>
	<div class="wrapper">
		<aside class="main-sidebar">
			<section class="sidebar" id="${namespace}${layoutKey}column-1" section-type="system">
				
				
				
				
			</section>
		</aside>
		<div class="content-wrapper">
			<div class="menu-panel">
				<div class="row" id="${namespace}menu-panel-box"></div>
			</div>
			<section class="content text-center" id="no-job-layout-area">
				<span>
				</span>
			</section>
			
			<section class="content" id="workbench-layout-area" style="display:none;height:94%;">
				<div class="container-fluid" style="height: 100%;">
					<#if INPUT_FILE_PATH?has_content>
						<#assign layoutKey="INPUT_">
						<div class="row flow-grid" style="display:none;height: 100%;" id="INPUT">
							<#include "*/${INPUT_FILE_PATH}">
						</div>
					</#if>
					<#if LOG_FILE_PATH?has_content>
						<#assign layoutKey="LOG_">
						<div class="row flow-grid" style="display:none;height: 100%;" id="LOG">
							<#include "*/${LOG_FILE_PATH}">
						</div>
					</#if>
					<#if OUTPUT_FILE_PATH?has_content>
						<#assign layoutKey="OUTPUT_">
						<div class="row flow-grid" style="display:none;height: 100%;" id="OUTPUT">
							<#include "*/${OUTPUT_FILE_PATH}">
						</div>
					</#if>
				</div>
			</section>
		</div>
	</div>
</div>