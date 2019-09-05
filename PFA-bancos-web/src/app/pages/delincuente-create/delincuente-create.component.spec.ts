import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DelincuenteCreateComponent } from './delincuente-create.component';

describe('DelincuenteCreateComponent', () => {
  let component: DelincuenteCreateComponent;
  let fixture: ComponentFixture<DelincuenteCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DelincuenteCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DelincuenteCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
