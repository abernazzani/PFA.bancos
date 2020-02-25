import { NgModule } from '@angular/core';
import { AsaltoIndexComponent } from './pages/index/index.component';
import { AsaltosEditComponent } from './pages/edit/edit.component';
import { AsaltosRoutingModule } from './asaltos.routing';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { DelincuentesModule } from '../delincuentes/delincuentes.module';


@NgModule({
    imports: [
        NgbModule,
        CommonModule,
        RouterModule,
        FormsModule,
        AsaltosRoutingModule,
        DelincuentesModule,
    ],
    exports: [],
    declarations: [AsaltoIndexComponent,
        AsaltosEditComponent],
    providers: [],
    entryComponents: [
        AsaltosEditComponent
    ]
})
export class AsaltosModule { }
