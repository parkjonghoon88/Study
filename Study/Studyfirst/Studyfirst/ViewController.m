//
//  ViewController.m
//  Studyfirst
//
//  Created by 박종훈 on 2016. 1. 17..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import "ViewController.h"

@interface ViewController () {

}

@property (nonatomic, strong) UIButton *btn;
@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    
//    self.view.backgroundColor = [UIColor redColor];
    [[self view] setBackgroundColor:[UIColor redColor]];
    
    _btn = [UIButton buttonWithType:UIButtonTypeSystem];
    [[self view] addSubview:self.btn];
    [self.btn setTitle:@"btn titlefdgdgdgd" forState:UIControlStateNormal];
    
    [self.btn addTarget:self action:@selector(didTapButton) forControlEvents:UIControlEventTouchUpInside];
    
}

- (void)viewWillLayoutSubviews{
    [super viewWillLayoutSubviews];
}

-(void) viewDidLayoutSubviews{
    [super viewDidLayoutSubviews];
    
    [self.btn sizeToFit];
    
    CGRect buttonFrame = self.btn.frame;
    buttonFrame.origin = CGPointMake(0, 100);
    
    self.btn.frame = buttonFrame;
    
    
}

-(void)didTapButton{
    
    float redNum = ((float)rand() / RAND_MAX) * 1;
        float greenNum = ((float)rand() / RAND_MAX) * 1;
        float blueNum = ((float)rand() / RAND_MAX) * 1;
    
    UIColor *color = [UIColor colorWithRed:redNum green:greenNum blue:blueNum alpha:1];
    
    [[self view] setBackgroundColor:color];
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
