import { NgModule } from '@angular/core';
import { JuecesIndexComponent } from './pages/index/index.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { JuecesEditComponent } from './pages/edit/edit.component';
import { JuecesRoutingModule } from './jueces.routing';
import { SharedModule } from 'src/app/shared/shared.module';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
    imports: [
        NgbModule,
        CommonModule,
        RouterModule,
        FormsModule,
        JuecesRoutingModule,
    ],
    exports: [
    ],
    declarations: [
        JuecesIndexComponent,
        JuecesEditComponent
    ],
    providers: [],
    entryComponents: [
        JuecesEditComponent,
    ]
})
export class JuecesModule { }
