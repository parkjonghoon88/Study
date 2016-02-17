//
//  RandomMain.h
//  Study2
//
//  Created by 박종훈 on 2016. 1. 30..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface RandomMain : NSObject

- (instancetype)initWithCount:(NSInteger)count fileName:(NSString *)fileName;

- (void)run;

@end
