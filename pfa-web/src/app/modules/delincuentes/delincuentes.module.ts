import { NgModule } from '@angular/core';
import { DelincuentesIndexComponent } from './pages/index/index.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { DelincuentesRoutingModule } from './delincuentes.routing';
import { DelincuentesEditComponent } from './pages/edit/edit.component';
import { DelincuentesChooseListComponent } from './components/delincuentes-choose-list/delincuentes-choose-list.component';


@NgModule({
    imports: [
        NgbModule,
        CommonModule,
        RouterModule,
        FormsModule,
        DelincuentesRoutingModule,
    ],
    exports: [DelincuentesChooseListComponent],
    declarations: [
        DelincuentesChooseListComponent,
        DelincuentesIndexComponent,
        DelincuentesEditComponent],
    providers: [],
    entryComponents: [
        DelincuentesEditComponent,
        DelincuentesChooseListComponent
    ]
})
export class DelincuentesModule { }
