import { NgModule } from '@angular/core';
import { CondenasIndexComponent } from './pages/index/index.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CondenasEditComponent } from './pages/edit/edit.component';
import { CondenasRoutingModule } from './condenas.routing';
import { SharedModule } from 'src/app/shared/shared.module';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
    imports: [
        NgbModule,
        CommonModule,
        RouterModule,
        FormsModule,
        CondenasRoutingModule,
    ],
    exports: [
    ],
    declarations: [
        CondenasIndexComponent,
        CondenasEditComponent
    ],
    providers: [],
    entryComponents: [
        CondenasEditComponent,
    ]
})
export class CondenasModule { }
